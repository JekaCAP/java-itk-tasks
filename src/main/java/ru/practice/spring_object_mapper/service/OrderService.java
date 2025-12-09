package ru.practice.spring_object_mapper.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.practice.java_spring_mvc.exception.EntityNotFoundException;
import ru.practice.spring_object_mapper.mapper.OrderMapper;
import ru.practice.spring_object_mapper.model.Customer;
import ru.practice.spring_object_mapper.model.Order;
import ru.practice.spring_object_mapper.model.OrderStatus;
import ru.practice.spring_object_mapper.model.Product;
import ru.practice.spring_object_mapper.model.dto.OrderRequest;
import ru.practice.spring_object_mapper.model.dto.OrderResponse;
import ru.practice.spring_object_mapper.repository.CustomerRepository;
import ru.practice.spring_object_mapper.repository.OrderRepository;
import ru.practice.spring_object_mapper.repository.ProductRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * OrderService
 *
 * @author agent
 * @since 09.12.2025
 */
@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;
    private final OrderMapper orderMapper;

    @Transactional
    public OrderResponse createOrder(OrderRequest request) {

        Customer customer = customerRepository.getOrThrow(request.customerId());

        List<Product> products = productRepository.findAllById(request.productIds());

        if (products.size() != request.productIds().size()) {
            throw new EntityNotFoundException("One or more products were not found");
        }

        for (Product product : products) {
            if (product.getQuantityInStock() == null || product.getQuantityInStock() <= 0) {
                throw new IllegalStateException("Out of stock: " + product.getName());
            }
        }

        BigDecimal totalPrice = products.stream()
                .map(Product::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        products.forEach(p ->
                p.setQuantityInStock(p.getQuantityInStock() - 1)
        );
        productRepository.saveAll(products);

        Order order = new Order();
        order.setCustomer(customer);
        order.setProducts(products);
        order.setOrderDate(LocalDateTime.now());
        order.setShippingAddress(request.shippingAddress());
        order.setTotalPrice(totalPrice);
        order.setOrderStatus(OrderStatus.PENDING);

        orderRepository.save(order);

        return orderMapper.toResponse(order);
    }

    @Transactional(readOnly = true)
    public OrderResponse getOrder(Long id) {
        Order order = orderRepository.getOrThrow(id);
        return orderMapper.toResponse(order);
    }
}