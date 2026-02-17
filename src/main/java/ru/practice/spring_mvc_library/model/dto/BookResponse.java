package ru.practice.spring_mvc_library.model.dto;

/**
 * BookResponse
 *
 * @author agent
 * @since 09.12.2025
 */
public record BookResponse (
        Long id,
        String title,
        Integer year,
        String authorName
) {}