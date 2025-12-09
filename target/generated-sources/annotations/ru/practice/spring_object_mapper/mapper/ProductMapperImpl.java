package ru.practice.spring_object_mapper.mapper;

import java.math.BigDecimal;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import ru.practice.spring_object_mapper.model.Product;
import ru.practice.spring_object_mapper.model.dto.ProductRequest;
import ru.practice.spring_object_mapper.model.dto.ProductResponse;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-12-09T17:00:40+0500",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.5 (Amazon.com Inc.)"
)
@Component
public class ProductMapperImpl implements ProductMapper {

    @Override
    public Product toEntity(ProductRequest request) {
        if ( request == null ) {
            return null;
        }

        Product product = new Product();

        return product;
    }

    @Override
    public ProductResponse toResponse(Product product) {
        if ( product == null ) {
            return null;
        }

        Long productId = null;
        String name = null;
        String description = null;
        BigDecimal price = null;
        Integer quantityInStock = null;

        ProductResponse productResponse = new ProductResponse( productId, name, description, price, quantityInStock );

        return productResponse;
    }
}
