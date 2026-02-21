package ru.practice.java_spring_mvc.service;

import ru.practice.java_spring_mvc.model.Order;
import ru.practice.java_spring_mvc.model.dto.OrderCreateDto;

/**
 * OrderService — описание интерфейса.
 * <p>
 * TODO: описать, какие обязанности реализует интерфейс.
 * </p>
 *
 * @author agent
 * @since 08.12.2025
 */
public interface OrderService {

    Order create(OrderCreateDto dto);

    Order findById(Long id);

    void delete(Long id);
}