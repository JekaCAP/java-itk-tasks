package ru.practice.spring_mvc_library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.practice.java_spring_mvc.exception.EntityNotFoundException;
import ru.practice.spring_mvc_library.model.Author;

/**
 * AuthorRepository
 *
 * @author agent
 * @since 09.12.2025
 */
public interface AuthorRepository extends JpaRepository<Author, Long> {

    default Author getOrThrow(Long id) {
        return findById(id).orElseThrow(
                () -> new EntityNotFoundException("Author not found" + id)
        );
    }
}