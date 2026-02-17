package ru.practice.spring_mvc_library.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/**
 * AuthorRequest
 *
 * @author agent
 * @since 09.12.2025
 */
public record AuthorRequest(
        @NotBlank
        @Size(max = 255)
        String name
) {
}