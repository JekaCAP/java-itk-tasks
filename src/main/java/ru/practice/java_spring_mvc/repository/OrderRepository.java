package ru.practice.java_spring_mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.practice.java_spring_mvc.model.Order;

/**
 * OrderRepository — описание интерфейса.
 * <p>
 * TODO: описать, какие обязанности реализует интерфейс.
 * </p>
 *
 * @author agent
 * @since 08.12.2025
 */
public interface OrderRepository extends JpaRepository<Order, Long> {

    default Order getOrThrow(Long id) {
        return findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Order not found" + id
                        )
                );
    }
}