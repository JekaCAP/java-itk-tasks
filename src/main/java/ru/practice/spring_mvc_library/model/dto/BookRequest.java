package ru.practice.spring_mvc_library.model.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

/**
 * BookRequest
 *
 * @author agent
 * @since 09.12.2025
 */
public record BookRequest(
        @NotBlank(message = "Title must not be blank")
        @Size(max = 255)
        String title,
        @NotNull
        @Min(1000)
        @Max(2100)
        Integer year,
        @NotNull(message = "Author ID must not be null")
        @Positive(message = "Author ID must be a positive number")
        Long authorId
) {
}