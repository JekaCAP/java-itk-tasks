package ru.practice.java_spring_mvc.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

/**
 * ErrorResponse — описание класса.
 * <p>
 * TODO: добавить описание назначения и поведения класса.
 * </p>
 *
 * @author agent
 * @since 08.12.2025
 */
@Getter
@Builder
@AllArgsConstructor
public class ErrorResponse {

    private final int status;

    private final String message;

    private final String timestamp;
}