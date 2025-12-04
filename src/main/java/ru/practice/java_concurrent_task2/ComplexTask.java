package ru.practice.java_concurrent_task2;

/**
 * @author agent
 * @since 04.12.2025
 */
public class ComplexTask {

    private final int taskId;

    public ComplexTask(int taskId) {
        this.taskId = taskId;
    }

    public String execute() {
        System.out.println(Thread.currentThread().getName() +
                           " выполняет задачу " + taskId);

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        return "Результат : " + taskId;
    }
}