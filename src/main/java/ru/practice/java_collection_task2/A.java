package ru.practice.java_collection_task2;

import java.util.List;
import java.util.stream.Collectors;

public class A {

    public void method() {

        var list = List.of("12345", "2345", "23456");

        System.out.println("===== FIRST STREAM =====");

        var collected = list.stream()
                .map(s -> {
                    System.out.println("map: " + s);
                    return s.length();
                })
                .filter(len -> {
                    System.out.println("filter: " + len);
                    return len > 4;
                })

                .peek(len -> System.out.println("peek: " + len))

                .collect(Collectors.toList());


        collected.forEach(len ->
                System.out.println("forEach (after collect): " + len)
        );

        System.out.println("===== SECOND STREAM =====");

        var str = "23556"; // просто чтобы соответствовать твоему шаблону

        list.stream()
                .sequential()
                .map(s -> s)
                .map(String::toString)
                .filter(s -> {
                    System.out.println("filter (sleep 5s): " + s);
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    return true;
                })
                .peek(s -> System.out.println("peek: " + s))
                .findFirst();
    }

    public static void main(String[] args) {
        new A().method();
    }
}
