package ru.practice.spring_data_projections.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.practice.spring_data_projections.entity.Department;

/**
 * DepartmentRepository
 * <p>
 * <p>
 * agent
 *
 * @since 15.12.2025
 */
public interface DepartmentRepository extends JpaRepository<Department, Long> {
}