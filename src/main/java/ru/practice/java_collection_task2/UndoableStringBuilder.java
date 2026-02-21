package ru.practice.java_collection_task2;

import java.util.ArrayDeque;
import java.util.Deque;

public class UndoableStringBuilder {

    private StringBuilder builder;

    private Deque<Memento> history;

    private static final int MAX_HISTORY_SIZE = 100;

    private static class Memento {

        private final String stage;

        private Memento(String stage) {
            this.stage = stage;
        }
    }

    public UndoableStringBuilder() {
        builder = new StringBuilder();
        this.history = new ArrayDeque<>();
    }

    public UndoableStringBuilder(String str) {
        builder = new StringBuilder(str);
        this.history = new ArrayDeque<>();
    }

    private void saveState() {
        history.push(new Memento(builder.toString()));

        if (history.size() > MAX_HISTORY_SIZE) {
            while (history.size() > MAX_HISTORY_SIZE) {
                history.removeLast();
            }
        }
    }

    public UndoableStringBuilder append(String str) {
        saveState();
        builder.append(str);
        return this;
    }

    public void undo() {
        if (!history.isEmpty()) {
            Memento lastStage = history.pop();
            builder = new StringBuilder(lastStage.stage);
        }
    }

    @Override
    public String toString() {
        return builder.toString();
    }


    public static void main(String[] args) {
        UndoableStringBuilder usb = new UndoableStringBuilder();

        usb.append("A");
        System.out.println("Добавили A: " + usb);

        usb.append("B");
        System.out.println("Добавили B: " + usb);

        usb.append("C");
        System.out.println("Добавили C: " + usb);

        usb.undo();
        System.out.println("Undo -> " + usb);

        usb.undo();
        System.out.println("Undo -> " + usb);

        usb.append("X");
        System.out.println("Добавили X: " + usb);
    }
}