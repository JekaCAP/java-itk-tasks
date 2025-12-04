package ru.practice.java_concurrency_task;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author agent
 * @since 04.12.2025
 */
public class BlockingQueue<T> {
    private final Queue<T> queue = new LinkedList<>();
    private final int capacity;

    public BlockingQueue(int capacity) {
        this.capacity = capacity;
    }

    public synchronized void enqueue(T element) throws InterruptedException {
        while (queue.size() == capacity) {
            wait();
        }

        queue.add(element);
        notifyAll();
    }

    public synchronized T dequeue() throws InterruptedException {
        while (queue.isEmpty()) {
            wait();
        }

        T value = queue.remove();
        notifyAll();
        return value;
    }

    public synchronized int size() {
        return queue.size();
    }
}