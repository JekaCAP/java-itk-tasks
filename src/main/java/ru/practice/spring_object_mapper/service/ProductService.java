package ru.practice.spring_object_mapper.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.practice.spring_object_mapper.mapper.ProductMapper;
import ru.practice.spring_object_mapper.model.Product;
import ru.practice.spring_object_mapper.model.dto.ProductRequest;
import ru.practice.spring_object_mapper.model.dto.ProductResponse;
import ru.practice.spring_object_mapper.repository.ProductRepository;

import java.util.List;

/**
 * ProductService
 *
 * @author agent
 * @since 09.12.2025
 */
@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Transactional
    public ProductResponse create(ProductRequest request) {
        Product product = productMapper.toEntity(request);
        productRepository.save(product);
        return productMapper.toResponse(product);
    }

    @Transactional(readOnly = true)
    public ProductResponse getById(Long id) {
        Product product = productRepository.getOrThrow(id);
        return productMapper.toResponse(product);
    }

    @Transactional(readOnly = true)
    public List<ProductResponse> getAll() {
        return productRepository.findAll()
                .stream()
                .map(productMapper::toResponse)
                .toList();
    }

    @Transactional
    public ProductResponse update(Long id, ProductRequest request) {
        Product product = productRepository.getOrThrow(id);
        product.setName(request.name());
        product.setDescription(request.description());
        product.setPrice(request.price());
        product.setQuantityInStock(request.quantityInStock());

        productRepository.save(product);
        return productMapper.toResponse(product);
    }

    @Transactional
    public void delete(Long id) {
        productRepository.delete(productRepository.getOrThrow(id));
    }
}