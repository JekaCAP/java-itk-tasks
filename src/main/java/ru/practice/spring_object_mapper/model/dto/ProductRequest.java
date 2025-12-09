package ru.practice.spring_object_mapper.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

/**
 * ProductRequest
 *
 * @author agent
 * @since 09.12.2025
 */
public record ProductRequest(
        @NotBlank
        @Size(max = 255)
        String name,

        @Size(max = 1000)
        String description,

        @NotNull
        @Positive
        BigDecimal price,

        @NotNull
        @Positive
        Integer quantityInStock
) {
}