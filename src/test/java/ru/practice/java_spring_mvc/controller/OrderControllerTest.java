package ru.practice.java_spring_mvc.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import ru.practice.java_spring_mvc.model.Order;
import ru.practice.java_spring_mvc.model.OrderStatus;
import ru.practice.java_spring_mvc.model.dto.OrderCreateDto;
import ru.practice.java_spring_mvc.service.OrderService;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(OrderController.class)
class OrderControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private OrderService orderService;

    @Autowired
    private ObjectMapper mapper;

    @Test
    void findById_shouldReturnOrderDetails() throws Exception {
        Order order = Order.builder()
                .id(10L)
                .productName("Laptop")
                .status(OrderStatus.CREATED)
                .total(BigDecimal.valueOf(1500))
                .build();

        Mockito.when(orderService.findById(10L)).thenReturn(order);

        mockMvc.perform(get("/api/orders/10"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(10L))
                .andExpect(jsonPath("$.productName").value("Laptop"))
                .andExpect(jsonPath("$.status").value("CREATED"))
                .andExpect(jsonPath("$.total").value(1500));
    }

    @Test
    void create_shouldReturn201_andOrderDetails() throws Exception {
        OrderCreateDto dto = OrderCreateDto.builder()
                .productName("Laptop")
                .status(OrderStatus.CREATED)
                .total(BigDecimal.valueOf(1500))
                .userId(1L)
                .build();

        Order created = Order.builder()
                .id(10L)
                .productName("Laptop")
                .status(OrderStatus.CREATED)
                .total(BigDecimal.valueOf(1500))
                .build();

        Mockito.when(orderService.create(Mockito.any())).thenReturn(created);

        mockMvc.perform(post("/api/orders")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(dto)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(10L))
                .andExpect(jsonPath("$.productName").value("Laptop"))
                .andExpect(jsonPath("$.status").value("CREATED"))
                .andExpect(jsonPath("$.total").value(1500));
    }

    @Test
    void create_shouldReturn400_ifProductNameIsBlank() throws Exception {
        OrderCreateDto dto = OrderCreateDto.builder()
                .productName("")
                .status(OrderStatus.CREATED)
                .total(BigDecimal.valueOf(100))
                .userId(1L)
                .build();

        mockMvc.perform(post("/api/orders")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(dto)))
                .andExpect(status().isBadRequest());
    }

    @Test
    void delete_shouldReturn204() throws Exception {
        mockMvc.perform(delete("/api/orders/5"))
                .andExpect(status().isNoContent());
    }
}