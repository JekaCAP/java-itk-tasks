package ru.practice.spring_object_mapper.model.dto;

/**
 * CustomerResponse
 *
 * @author agent
 * @since 09.12.2025
 */
public record CustomerResponse(
        Long customerId,
        String firstName,
        String lastName,
        String email,
        String contactNumber
) {}