package ru.practice.spring_object_mapper.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.practice.java_spring_mvc.exception.EntityNotFoundException;
import ru.practice.spring_object_mapper.model.Product;

/**
 * ProductRepository
 *
 * @author agent
 * @since 09.12.2025
 */
public interface ProductRepository extends JpaRepository<Product, Long> {

    default Product getOrThrow(Long id) {
        return findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("Product not found: " + id)
                );
    }
}