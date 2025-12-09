package ru.practice.spring_object_mapper.mapper;

import org.mapstruct.Mapper;
import ru.practice.spring_object_mapper.model.Customer;
import ru.practice.spring_object_mapper.model.dto.CustomerRequest;
import ru.practice.spring_object_mapper.model.dto.CustomerResponse;

/**
 * CustomerMapper
 *
 * @author agent
 * @since 09.12.2025
 */
@Mapper(componentModel = "spring")
public interface CustomerMapper {
    Customer toEntity(CustomerRequest request);
    CustomerResponse toResponse(Customer customer);
}