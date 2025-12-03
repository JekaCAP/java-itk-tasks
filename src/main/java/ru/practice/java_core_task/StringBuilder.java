package ru.practice.java_core_task;

public class StringBuilder {

    private char[] value;

    private int count;

    public StringBuilder() {
        value = new char[16];
        count = 0;
    }

    public StringBuilder(String str) {
        value = new char[str.length() + 16];
        str.getChars(0, str.length(), value, 0);
        count = str.length();
    }
}