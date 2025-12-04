package ru.practice.java_concurrent_task2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author agent
 * @since 04.12.2025
 */
public class ComplexTaskExecutor {

    private int tasksCount;
    private final List<String> results = new ArrayList<>();

    public ComplexTaskExecutor(int tasksCount) {
        this.tasksCount = tasksCount;
    }

    public void executeTasks(int numberOfTasks) {

        CyclicBarrier barrier = new CyclicBarrier(numberOfTasks, () -> {
            System.out.println("\n=== Все задачи завершены. Объединяем результаты... ===");
            results.forEach(System.out::println);
            System.out.println("=== Объединение завершено ===\n");
        });

        ExecutorService executor = Executors.newFixedThreadPool(numberOfTasks);

        for (int i = 0; i < numberOfTasks; i++) {
            int taskId = i;

            executor.submit(() -> {
                try {
                    ComplexTask task = new ComplexTask(taskId);

                    String result = task.execute();
                    synchronized (results) {
                        results.add(result);
                    }

                    System.out.println(Thread.currentThread().getName() + " ждет на барьере...");
                    barrier.await();
                } catch (InterruptedException | BrokenBarrierException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }

        executor.shutdown();
        try {
            executor.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}