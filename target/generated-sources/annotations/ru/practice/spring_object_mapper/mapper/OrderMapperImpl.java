package ru.practice.spring_object_mapper.mapper;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import ru.practice.spring_object_mapper.model.Order;
import ru.practice.spring_object_mapper.model.OrderStatus;
import ru.practice.spring_object_mapper.model.dto.CustomerResponse;
import ru.practice.spring_object_mapper.model.dto.OrderResponse;
import ru.practice.spring_object_mapper.model.dto.ProductResponse;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-12-09T17:00:40+0500",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.5 (Amazon.com Inc.)"
)
@Component
public class OrderMapperImpl implements OrderMapper {

    @Override
    public OrderResponse toResponse(Order order) {
        if ( order == null ) {
            return null;
        }

        Long orderId = null;
        CustomerResponse customer = null;
        List<ProductResponse> products = null;
        LocalDateTime orderDate = null;
        String shippingAddress = null;
        BigDecimal totalPrice = null;
        OrderStatus orderStatus = null;

        OrderResponse orderResponse = new OrderResponse( orderId, customer, products, orderDate, shippingAddress, totalPrice, orderStatus );

        return orderResponse;
    }
}
