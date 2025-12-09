package ru.practice.spring_object_mapper.mapper;

import org.mapstruct.Mapper;
import ru.practice.spring_object_mapper.model.Order;
import ru.practice.spring_object_mapper.model.dto.OrderResponse;

/**
 * OrderMapper
 *
 * @author agent
 * @since 09.12.2025
 */
@Mapper(componentModel = "spring", uses = {ProductMapper.class, CustomerMapper.class})
public interface OrderMapper {

    OrderResponse toResponse(Order order);
}