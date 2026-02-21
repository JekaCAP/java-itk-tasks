package ru.practice.java_spring_mvc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.practice.java_spring_mvc.model.User;
import ru.practice.java_spring_mvc.model.dto.UserCreateDto;
import ru.practice.java_spring_mvc.model.dto.UserUpdateDto;
import ru.practice.java_spring_mvc.repository.UserRepository;

import java.util.List;

/**
 * UserServiceImpl — описание класса.
 * <p>
 * TODO: добавить описание назначения и поведения класса.
 * </p>
 *
 * @author agent
 * @since 08.12.2025
 */
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        return userRepository.getOrThrow(id);
    }

    @Override
    @Transactional
    public User create(UserCreateDto dto) {
        User user = User.builder()
                .name(dto.getName())
                .surname(dto.getSurname())
                .email(dto.getEmail())
                .build();

        return userRepository.save(user);
    }

    @Override
    @Transactional
    public User update(Long id, UserUpdateDto dto) {
        User user = userRepository.getOrThrow(id);

        user.setName(dto.getName());
        user.setEmail(dto.getEmail());

        return userRepository.save(user);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        userRepository.delete(userRepository.getOrThrow(id));
    }
}