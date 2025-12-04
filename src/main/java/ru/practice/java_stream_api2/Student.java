package ru.practice.java_stream_api2;

import java.util.Map;

/**
 * @author agent
 * @since 05.12.2025
 */
class Student {
    private final String name;
    private final Map<String, Integer> grades;

    public Student(String name, Map<String, Integer> grades) {
        this.name = name;
        this.grades = grades;
    }

    public Map<String, Integer> getGrades() {
        return grades;
    }
}