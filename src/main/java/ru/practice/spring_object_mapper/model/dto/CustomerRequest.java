package ru.practice.spring_object_mapper.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * CustomerRequest
 *
 * @author agent
 * @since 09.12.2025
 */
public record CustomerRequest(
        @NotBlank @Size(max = 100) String firstName,
        @NotBlank @Size(max = 100) String lastName,
        @NotBlank @Email @Size(max = 255) String email,
        @NotBlank @Size(max = 50) String contactNumber
) {}