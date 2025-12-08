package ru.practice.java_spring_mvc.controller;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.practice.java_spring_mvc.model.User;
import ru.practice.java_spring_mvc.model.dto.UserCreateDto;
import ru.practice.java_spring_mvc.model.dto.UserUpdateDto;
import ru.practice.java_spring_mvc.service.UserService;
import ru.practice.java_spring_mvc.view.Views;

import java.util.List;

/**
 * UserController — описание класса.
 * <p>
 * TODO: добавить описание назначения и поведения класса.
 * </p>
 *
 * @author agent
 * @since 08.12.2025
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @GetMapping
    @JsonView(Views.UserSummary.class)
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    @JsonView(Views.UserDetails.class)
    public User findById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @PostMapping
    @JsonView(Views.UserDetails.class)
    public User create(@RequestBody @Valid UserCreateDto dto) {
        return userService.create(dto);
    }

    @PutMapping("/{id}")
    @JsonView(Views.UserDetails.class)
    public User update(@PathVariable Long id,
                       @RequestBody @Valid UserUpdateDto dto) {
        return userService.update(id, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }
}