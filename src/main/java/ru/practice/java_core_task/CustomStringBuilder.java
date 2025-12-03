package ru.practice.java_core_task;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Кастомный StringBuilder с базовой функциональностью.
 * Хранит символы в массиве, автоматически расширяется.
 *
 * @author agent
 * @since 02.12.2025
 */
public class CustomStringBuilder {

    private char[] value;

    private int count;

    private final Deque<StringBuilderMemento> history = new ArrayDeque<>();

    public CustomStringBuilder() {
        this(16);
        saveState();
    }

    /**
     * Создаёт StringBuilder с указанной начальной ёмкостью.
     *
     * @param capacity начальная ёмкость
     * @throws NegativeArraySizeException если capacity отрицательное
     */
    public CustomStringBuilder(int capacity) {
        value = new char[capacity];
        count = 0;
        saveState();
    }

    /**
     * Создаёт StringBuilder с начальной строкой.
     * Ёмкость = длина строки + 16.
     *
     * @param str начальная строка
     */
    public CustomStringBuilder(String str) {
        this(str.length() + 16);
        append(str);
    }

    private void saveState() {
        history.push(new StringBuilderMemento(toString()));
    }

    private void restoreFromMemento(StringBuilderMemento memento) {
        String state = memento.getState();
        count = state.length();
        ensureCapacity(count);
        state.getChars(0, count, value, 0);
    }

    /**
     * Отменяет последнюю операцию.
     * Восстанавливает предыдущее состояние из истории.
     *
     * @return true если отмена выполнена, false если нечего отменять
     */
    public boolean undo() {
        if (history.size() > 1) {
            history.pop();
            StringBuilderMemento previous = history.peek();
            restoreFromMemento(previous);
            return true;
        }
        return false;
    }

    /**
     * Добавляет строку в конец.
     *
     * @param str добавляемая строка (null конвертируется в "null")
     * @return this для chaining
     */
    public CustomStringBuilder append(String str) {
        if (str == null) {
            str = "null";
        }

        int len = str.length();
        ensureCapacity(count + len);

        str.getChars(0, len, value, count);
        count += len;

        saveState();
        return this;
    }

    public CustomStringBuilder insert(int offset, String str) {
        if (offset < 0 || offset > count) {
            throw new StringIndexOutOfBoundsException("Invalid offset: " + offset);
        }

        if (str == null) {
            str = "null";
        }

        int len = str.length();
        ensureCapacity(count + len);

        System.arraycopy(value, offset, value, offset + len, count - offset);

        str.getChars(0, len, value, offset);
        count += len;

        saveState();
        return this;
    }

    public CustomStringBuilder delete(int start, int end) {
        if (start < 0 || end > count || start > end) {
            throw new StringIndexOutOfBoundsException(
                    String.format("Invalid range: start=%d, end=%d, length=%d", start, end, count)
            );
        }

        int len = end - start;
        if (len > 0) {
            System.arraycopy(value, end, value, start, count - end);
            count -= len;
        }

        saveState();
        return this;
    }

    public CustomStringBuilder reverse() {
        for (int i = 0, j = count - 1; i < j; i++, j--) {
            char temp = value[i];
            value[i] = value[j];
            value[j] = temp;
        }

        saveState();
        return this;
    }

    public char charAt(int index) {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Length: " + count);
        }
        return value[index];
    }

    public void setCharAt(int index, char ch) {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Length: " + count);
        }
        value[index] = ch;
        saveState();
    }

    /**
     * Гарантирует минимальную ёмкость массива.
     * Увеличивает массив в 2 раза + 2 при необходимости.
     *
     * @param minCapacity минимальная требуемая ёмкость
     */
    private void ensureCapacity(int minCapacity) {
        if (minCapacity > value.length) {
            int newCapacity = value.length * 2 + 2;
            if (newCapacity < minCapacity) {
                newCapacity = minCapacity;
            }

            char[] newValue = new char[newCapacity];

            System.arraycopy(value, 0, newValue, 0, count);
            value = newValue;
        }
    }

    /**
     * Добавляет строковое представление объекта.
     *
     * @param obj объект (вызывается obj.toString())
     * @return this для chaining
     */
    public CustomStringBuilder append(Object obj) {
        return append(String.valueOf(obj));
    }

    /**
     * Добавляет число.
     *
     * @param num добавляемое число
     * @return this для chaining
     */
    public CustomStringBuilder append(int num) {
        return append(String.valueOf(num));
    }

    /**
     * Возвращает текущую строку.
     *
     * @return строка из использованных символов
     */
    @Override
    public String toString() {
        return new String(value, 0, count);
    }

    /**
     * Возвращает текущую длину строки.
     *
     * @return количество символов
     */
    public int length() {
        return count;
    }

    /**
     * Возвращает текущую ёмкость массива.
     *
     * @return размер внутреннего массива
     */
    public int capacity() {
        return value.length;
    }

    /**
     * Возвращает размер истории (для тестирования).
     *
     * @return количество сохранённых состояний
     */
    public int getHistorySize() {
        return history.size();
    }
}