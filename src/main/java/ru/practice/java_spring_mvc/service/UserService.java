package ru.practice.java_spring_mvc.service;

import ru.practice.java_spring_mvc.model.User;
import ru.practice.java_spring_mvc.model.dto.UserCreateDto;
import ru.practice.java_spring_mvc.model.dto.UserUpdateDto;

import java.util.List;

/**
 * UserService — описание класса.
 * <p>
 * TODO: добавить описание назначения и поведения класса.
 * </p>
 *
 * @author agent
 * @since 08.12.2025
 */
public interface UserService {

    List<User> findAll();

    User findById(Long id);

    User create(UserCreateDto dto);

    User update(Long id, UserUpdateDto dto);

    void delete(Long id);
}