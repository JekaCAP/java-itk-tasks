package ru.practice.java_collection_task2;

import java.util.HashMap;
import java.util.Map;

/**
 * @author agent
 * @since 03.12.2025
 */
public class Main {
    public static Map<String, Integer> countElements(String[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Array must not be null");
        }

        Map<String, Integer> map = new HashMap<>();

        for (String element : array) {
            if (map.containsKey(element)) {
                int current = map.get(element);
                map.put(element, current + 1);
            } else {
                map.put(element, 1);
            }
        }

        return map;
    }


    public static void main(String[] args) {
        String[] words = {"apple", "banana", "apple", "orange", "banana", "apple"};

        Map<String, Integer> result = countElements(words);

        System.out.println(result);
    }
}