package ru.practice.spring_data_projections.entity.dto;

import java.math.BigDecimal;

/**
 * EmployeeResponse
 *
 * @author agent
 * @since 15.12.2025
 */
public record EmployeeResponse(
        Long id,
        String firstName,
        String lastName,
        String position,
        BigDecimal salary,
        String departmentName
) {
}