package ru.practice.spring_object_mapper.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

/**
 * OrderRequest
 *
 * @author agent
 * @since 09.12.2025
 */
public record OrderRequest(
        @NotNull
        Long customerId,

        @NotNull
        List<Long> productIds,

        @NotBlank
        String shippingAddress
) {}