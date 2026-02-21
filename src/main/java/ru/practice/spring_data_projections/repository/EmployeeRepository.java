package ru.practice.spring_data_projections.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.practice.spring_data_projections.entity.Employee;
import ru.practice.spring_data_projections.projection.EmployeeProjection;

/**
 * EmployeeRepository
 *
 * @author agent
 * @since 15.12.2025
 */
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("""
            select
              concat(e.firstName, ' ', e.lastName) as fullName,
              e.position as position,
              d.departmentName as departmentName
            from Employee e
            join e.department d
            """)
    Page<EmployeeProjection> findAllProjected(Pageable pageable);
}