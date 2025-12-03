package ru.practice.java_collection_task;

/**
 * @author agent
 * @since 03.12.2025
 */
@FunctionalInterface
public interface Filter<T> {
    T apply(T t);
}