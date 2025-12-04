package ru.practice.java_stream_api;

import java.util.concurrent.ForkJoinPool;

/**
 * @author agent
 * @since 05.12.2025
 */
public class ForkJoinPoolExample {
    public static void main(String[] args) {
        int n = 10;

        ForkJoinPool pool = new ForkJoinPool();
        long factorial = pool.invoke(new FactorialTask(n));

        System.out.println("Факториал " + n + "! = " + factorial);
    }
}