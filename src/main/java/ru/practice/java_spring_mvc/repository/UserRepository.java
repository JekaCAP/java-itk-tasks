package ru.practice.java_spring_mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.practice.java_spring_mvc.model.User;

/**
 * UserRepository — описание интерфейса.
 * <p>
 * TODO: описать, какие обязанности реализует интерфейс.
 * </p>
 *
 * @author agent
 * @since 08.12.2025
 */
public interface UserRepository extends JpaRepository<User, Long> {

    default User getOrThrow(Long id) {
        return findById(id).orElseThrow(
                () -> new IllegalStateException("User with id " + id + " not found"
                )
        );
    }
}