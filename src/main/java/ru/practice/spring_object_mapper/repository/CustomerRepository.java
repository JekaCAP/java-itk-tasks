package ru.practice.spring_object_mapper.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.practice.java_spring_mvc.exception.EntityNotFoundException;
import ru.practice.spring_object_mapper.model.Customer;

/**
 * CustomerRepository
 *
 * @author agent
 * @since 09.12.2025
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    default Customer getOrThrow(Long id) {
        return findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("Customer not found: " + id)
                );
    }
}