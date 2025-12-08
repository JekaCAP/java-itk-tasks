package ru.practice.java_spring_mvc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.practice.java_spring_mvc.model.Order;
import ru.practice.java_spring_mvc.model.User;
import ru.practice.java_spring_mvc.model.dto.OrderCreateDto;
import ru.practice.java_spring_mvc.repository.OrderRepository;
import ru.practice.java_spring_mvc.repository.UserRepository;

/**
 * OrderServiceImpl — описание класса.
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
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;

    @Override
    @Transactional
    public Order create(OrderCreateDto dto) {
        User user = userRepository.getOrThrow(dto.getUserId());

        Order order = Order.builder()
                .productName(dto.getProductName())
                .status(dto.getStatus())
                .total(dto.getTotal())
                .user(user)
                .build();

        return orderRepository.save(order);
    }

    @Override
    public Order findById(Long id) {
        return orderRepository.getOrThrow(id);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        orderRepository.delete(orderRepository.getOrThrow(id));
    }
}