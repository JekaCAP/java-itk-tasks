package ru.practice.spring_object_mapper.model.dto;

import ru.practice.spring_object_mapper.model.OrderStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * OrderResponse
 *
 * @author agent
 * @since 09.12.2025
 */
public record OrderResponse(
        Long orderId,
        CustomerResponse customer,
        List<ProductResponse> products,
        LocalDateTime orderDate,
        String shippingAddress,
        BigDecimal totalPrice,
        OrderStatus orderStatus
) {}