package ru.practice.java_spring_mvc.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import ru.practice.java_spring_mvc.model.User;
import ru.practice.java_spring_mvc.model.dto.UserCreateDto;
import ru.practice.java_spring_mvc.model.dto.UserUpdateDto;
import ru.practice.java_spring_mvc.service.UserService;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Autowired
    private ObjectMapper mapper;

    @Test
    void findAll_shouldReturnUserSummaryView() throws Exception {
        User user = User.builder()
                .id(1L)
                .name("John")
                .surname("Doe")
                .email("john@mail.com")
                .build();

        Mockito.when(userService.findAll()).thenReturn(List.of(user));

        mockMvc.perform(get("/api/users"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1L))
                .andExpect(jsonPath("$[0].name").value("John"))
                .andExpect(jsonPath("$[0].surname").value("Doe"))
                .andExpect(jsonPath("$[0].email").value("john@mail.com"));
    }

    @Test
    void findById_shouldReturnUserDetailsView() throws Exception {
        User user = User.builder()
                .id(1L)
                .name("John")
                .surname("Doe")
                .email("john@mail.com")
                .build();

        Mockito.when(userService.findById(1L)).thenReturn(user);

        mockMvc.perform(get("/api/users/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.name").value("John"))
                .andExpect(jsonPath("$.surname").value("Doe"))
                .andExpect(jsonPath("$.email").value("john@mail.com"));
    }

    @Test
    void create_shouldValidateEmail_andReturn400() throws Exception {
        UserCreateDto dto = new UserCreateDto("John", "Doe", "wrong_email");

        mockMvc.perform(post("/api/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(dto)))
                .andExpect(status().isBadRequest());
    }

    @Test
    void update_shouldReturnUpdatedUser() throws Exception {
        UserUpdateDto dto = new UserUpdateDto("Johny", "new@mail.com");

        User updated = User.builder()
                .id(1L)
                .name("Johny")
                .surname("Doe")
                .email("new@mail.com")
                .build();

        Mockito.when(userService.update(Mockito.eq(1L), Mockito.any()))
                .thenReturn(updated);

        mockMvc.perform(put("/api/users/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(dto)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.name").value("Johny"))
                .andExpect(jsonPath("$.email").value("new@mail.com"));
    }

    @Test
    void delete_shouldReturn204() throws Exception {
        mockMvc.perform(delete("/api/users/1"))
                .andExpect(status().isNoContent());
    }
}