package ru.practice.spring_object_mapper.mapper;

import org.mapstruct.Mapper;
import ru.practice.spring_object_mapper.model.Product;
import ru.practice.spring_object_mapper.model.dto.ProductRequest;
import ru.practice.spring_object_mapper.model.dto.ProductResponse;

/**
 * ProductMapper
 *
 * @author agent
 * @since 09.12.2025
 */
@Mapper(componentModel = "spring")
public interface ProductMapper {
    Product toEntity(ProductRequest request);

    ProductResponse toResponse(Product product);
}