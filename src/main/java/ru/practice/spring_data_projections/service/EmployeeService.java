package ru.practice.spring_data_projections.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ru.practice.spring_data_projections.entity.dto.CreateEmployeeRequest;
import ru.practice.spring_data_projections.entity.dto.EmployeeResponse;
import ru.practice.spring_data_projections.projection.EmployeeProjection;

/**
 * EmployeeService
 *
 * @author agent
 * @since 15.12.2025
 */
public interface EmployeeService {

    EmployeeResponse create(CreateEmployeeRequest request);

    Page<EmployeeProjection> findAll(Pageable pageable);

    EmployeeResponse findById(Long id);

    void update(Long id, CreateEmployeeRequest request);

    void delete(Long id);
}