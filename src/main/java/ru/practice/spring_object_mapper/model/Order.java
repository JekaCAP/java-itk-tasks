package ru.practice.spring_object_mapper.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Order
 *
 * @author agent
 * @since 09.12.2025
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @ManyToOne(fetch = FetchType.LAZY)
    private Customer customer;

    @ManyToMany(fetch = FetchType.LAZY)
    private List<Product> products;

    private LocalDateTime orderDate;
    private String shippingAddress;
    private BigDecimal totalPrice;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;
}