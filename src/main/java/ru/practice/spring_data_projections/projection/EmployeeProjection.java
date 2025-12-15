package ru.practice.spring_data_projections.projection;

/**
 * EmployeeProjection
 *
 * @author agent
 * @since 15.12.2025
 */
public interface EmployeeProjection {

    String getFullName();

    String getPosition();

    String getDepartmentName();
}