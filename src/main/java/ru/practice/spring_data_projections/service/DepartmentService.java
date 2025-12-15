package ru.practice.spring_data_projections.service;

import ru.practice.spring_data_projections.entity.dto.CreateDepartmentRequest;
import ru.practice.spring_data_projections.entity.dto.DepartmentResponse;

/**
 * DepartmentService
 *
 * @author agent
 * @since 15.12.2025
 */
public interface DepartmentService {

    DepartmentResponse create(CreateDepartmentRequest request);
}