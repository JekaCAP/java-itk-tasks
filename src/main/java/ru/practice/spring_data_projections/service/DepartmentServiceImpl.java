package ru.practice.spring_data_projections.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.practice.spring_data_projections.entity.Department;
import ru.practice.spring_data_projections.entity.dto.CreateDepartmentRequest;
import ru.practice.spring_data_projections.entity.dto.DepartmentResponse;
import ru.practice.spring_data_projections.repository.DepartmentRepository;

/**
 * DepartmentServiceImpl
 *
 * @author agent
 * @since 15.12.2025
 */
@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Override
    @Transactional
    public DepartmentResponse create(CreateDepartmentRequest request) {
        Department department = new Department();
        department.setDepartmentName(request.departmentName());

        Department saved = departmentRepository.save(department);

        return new DepartmentResponse(saved.getId(), saved.getDepartmentName());
    }
}