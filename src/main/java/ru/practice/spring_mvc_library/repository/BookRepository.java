package ru.practice.spring_mvc_library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.practice.java_spring_mvc.exception.EntityNotFoundException;
import ru.practice.spring_mvc_library.model.Book;

/**
 * BookRepository
 *
 * @author agent
 * @since 09.12.2025
 */
public interface BookRepository extends JpaRepository<Book, Long> {

    default Book getOrThrow(Long id) {
        return findById(id).orElseThrow(
                () -> new EntityNotFoundException("Book not found" + id)
        );
    }
}