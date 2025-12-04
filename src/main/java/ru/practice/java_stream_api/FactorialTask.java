package ru.practice.java_stream_api;

import java.util.concurrent.RecursiveTask;

/**
 * @author agent
 * @since 05.12.2025
 */
public class FactorialTask extends RecursiveTask<Long> {
    private final int number;

    public FactorialTask(int number) {
        this.number = number;
    }

    @Override
    protected Long compute() {
        if (number <= 1) {
            return 1L;
        }

        FactorialTask subTask = new FactorialTask(number - 1);
        subTask.fork();
        long result = number * subTask.join();
        return result;
    }
}