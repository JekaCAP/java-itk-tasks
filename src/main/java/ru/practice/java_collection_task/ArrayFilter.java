package ru.practice.java_collection_task;

import java.lang.reflect.Array;

/**
 * @author agent
 * @since 03.12.2025
 */
public class ArrayFilter {
    public static <T> T[] filter(T[] array, Filter<T> filter) {
        if (array == null || filter == null) {
            throw new IllegalArgumentException("Array and Filter must not be null");
        }

        @SuppressWarnings("unchecked")
        T[] result = (T[]) Array.newInstance(array.getClass().getComponentType(), array.length);

        for (int i = 0; i < array.length; i++) {
            result[i] = filter.apply(array[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        String[] words = {"hello", "world", "java", "filter"};

        Filter<String> toUpperCaseFilter = s -> s.toUpperCase();

        String[] filtered = filter(words, toUpperCaseFilter);

        for (String s : filtered) {
            System.out.println(s);
        }
    }
}