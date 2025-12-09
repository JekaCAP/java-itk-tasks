package ru.practice.spring_object_mapper.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.practice.java_spring_mvc.exception.EntityNotFoundException;
import ru.practice.spring_object_mapper.model.Order;

/**
 * OrderRepository
 *
 * @author agent
 * @since 09.12.2025
 */
public interface OrderRepository extends JpaRepository<Order, Long> {

    default Order getOrThrow(Long id) {
        return findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("Order not found: " + id)
                );
    }
}