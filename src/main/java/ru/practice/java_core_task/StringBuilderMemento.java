package ru.practice.java_core_task;

/**
 *
 * Memento - хранитель состояния StringBuilder.
 * Это immutable объект, который хранит снимок состояния.
 *
 * @author agent
 * @since 02.12.2025
 */
public class StringBuilderMemento {
    private final String state;

    StringBuilderMemento(String state) {
        this.state = state;
    }

    String getState() {
        return state;
    }
}