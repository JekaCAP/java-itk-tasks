package ru.practice.spring_data_projections.entity.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

/**
 * CreateEmployeeRequest
 *
 * @author agent
 * @since 15.12.2025
 */
public record CreateEmployeeRequest(
        @NotBlank @Size(max = 50) String firstName,
        @NotBlank String lastName,
        @NotBlank String position,
        @Positive @NotNull BigDecimal salary,
        @NotNull Long departmentId
) {
}