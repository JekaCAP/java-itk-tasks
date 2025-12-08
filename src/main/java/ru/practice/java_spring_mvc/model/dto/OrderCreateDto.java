package ru.practice.java_spring_mvc.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.practice.java_spring_mvc.model.OrderStatus;

import java.math.BigDecimal;

/**
 * OrderCreateDto — описание класса.
 * <p>
 * TODO: добавить описание назначения и поведения класса.
 * </p>
 *
 * @author agent
 * @since 08.12.2025
 */
@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class OrderCreateDto {

    @NotBlank(message = "Email is required")
    private String productName;

    @NotNull
    private OrderStatus status;

    @NotNull
    private BigDecimal total;

    @NotNull
    private Long userId;
}