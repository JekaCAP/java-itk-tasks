package ru.practice.spring_data_projections.service;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.practice.java_spring_mvc.exception.EntityNotFoundException;
import ru.practice.spring_data_projections.entity.Department;
import ru.practice.spring_data_projections.entity.Employee;
import ru.practice.spring_data_projections.entity.dto.CreateEmployeeRequest;
import ru.practice.spring_data_projections.entity.dto.EmployeeResponse;
import ru.practice.spring_data_projections.projection.EmployeeProjection;
import ru.practice.spring_data_projections.repository.DepartmentRepository;
import ru.practice.spring_data_projections.repository.EmployeeRepository;

/**
 * EmployeeServiceImpl
 *
 * @author agent
 * @since 15.12.2025
 */
@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    private final DepartmentRepository departmentRepository;

    @Override
    @Transactional
    public EmployeeResponse create(CreateEmployeeRequest request) {
        Department department = departmentRepository.findById(request.departmentId())
                .orElseThrow(() -> new EntityNotFoundException("Department not found"));

        Employee employee = new Employee();
        employee.setFirstName(request.firstName());
        employee.setLastName(request.lastName());
        employee.setPosition(request.position());
        employee.setSalary(request.salary());
        employee.setDepartment(department);

        employee = employeeRepository.save(employee);

        return new EmployeeResponse(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getPosition(),
                employee.getSalary(),
                employee.getDepartment().getDepartmentName()
        );
    }

    @Override
    @Transactional(readOnly = true)
    public Page<EmployeeProjection> findAll(Pageable pageable) {
        return employeeRepository.findAllProjected(pageable);
    }

    @Override
    public EmployeeResponse findById(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Employee not found"));

        return new EmployeeResponse(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getPosition(),
                employee.getSalary(),
                employee.getDepartment().getDepartmentName()
        );
    }

    @Override
    @Transactional
    public void update(Long id, CreateEmployeeRequest request) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Employee not found"));

        Department department = departmentRepository.findById(request.departmentId())
                .orElseThrow(() -> new EntityNotFoundException("Department not found"));

        employee.setFirstName(request.firstName());
        employee.setLastName(request.lastName());
        employee.setPosition(request.position());
        employee.setSalary(request.salary());
        employee.setDepartment(department);

        employeeRepository.save(employee);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Employee not found"));

        employeeRepository.delete(employee);
    }
}