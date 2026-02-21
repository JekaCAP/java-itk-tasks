package ru.practice.spring_data_projections.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.practice.spring_data_projections.entity.dto.CreateDepartmentRequest;
import ru.practice.spring_data_projections.entity.dto.DepartmentResponse;
import ru.practice.spring_data_projections.service.DepartmentService;

/**
 * DepartmentController
 *
 * @author agent
 * @since 15.12.2025
 */
@RestController
@AllArgsConstructor
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<DepartmentResponse> create(@RequestBody @Valid CreateDepartmentRequest createDepartmentRequest) {
        DepartmentResponse response = departmentService.create(createDepartmentRequest);
        return ResponseEntity.status(201).body(response);
    }
}