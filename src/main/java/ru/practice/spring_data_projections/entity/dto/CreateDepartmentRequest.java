package ru.practice.spring_data_projections.entity.dto;

import jakarta.validation.constraints.NotBlank;

/**
 * CreateDepartmentRequest
 *
 * @author agent
 * @since 15.12.2025
 */
public record CreateDepartmentRequest(
        @NotBlank String departmentName
) {
}