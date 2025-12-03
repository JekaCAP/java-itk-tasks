package ru.practice.java_core_task;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== CUSTOM STRING BUILDER ===");

        System.out.println("[ТЕСТ 1] Базовые операции:");
        CustomStringBuilder sb1 = new CustomStringBuilder();
        System.out.println(String.format("  Создан: длина=%d, ёмкость=%d",
                sb1.length(), sb1.capacity()));

        sb1.append("Привет");
        System.out.println(String.format("  append('Привет'): '%s'", sb1));

        sb1.append(" мир!");
        System.out.println(String.format("  append(' мир!'): '%s'", sb1));
        System.out.println();

        System.out.println("[ТЕСТ 2] Отмена операций (undo):");
        CustomStringBuilder sb2 = new CustomStringBuilder("Старт");
        System.out.println(String.format("  Исходное: '%s'", sb2));

        sb2.append(" → шаг1");
        System.out.println(String.format("  + ' → шаг1': '%s'", sb2));

        sb2.append(" → шаг2");
        System.out.println(String.format("  + ' → шаг2': '%s'", sb2));

        sb2.undo();
        System.out.println(String.format("  undo(): '%s'", sb2));

        sb2.undo();
        System.out.println(String.format("  undo(): '%s'", sb2));
        System.out.println();

        System.out.println("[ТЕСТ 3] Разные операции:");
        CustomStringBuilder sb3 = new CustomStringBuilder("ABCD");
        System.out.println(String.format("  Исходное: '%s'", sb3));

        sb3.reverse();
        System.out.println(String.format("  reverse(): '%s'", sb3));

        sb3.insert(2, "123");
        System.out.println(String.format("  insert(2,'123'): '%s'", sb3));

        sb3.delete(2, 5);
        System.out.println(String.format("  delete(2,5): '%s'", sb3));
        System.out.println();

        System.out.println("[ТЕСТ 4] Цепочка вызовов (chaining):");
        String result = new CustomStringBuilder()
                .append("Java")
                .append(" ")
                .append("is")
                .append(" ")
                .append("cool")
                .append("!")
                .toString();
        System.out.println(String.format("  Цепочка: '%s'", result));
        System.out.println();

        System.out.println("[ТЕСТ 5] История состояний:");
        CustomStringBuilder sb5 = new CustomStringBuilder();
        sb5.append("A").append("B").append("C");
        System.out.println(String.format("  Состояние: '%s'", sb5));
        System.out.println(String.format("  Сохранено состояний: %d", sb5.getHistorySize()));
        System.out.println();

        System.out.println("[ТЕСТ 6] Граничные случаи:");
        CustomStringBuilder sb6 = new CustomStringBuilder();
        System.out.println(String.format("  undo() на пустом: %s", sb6.undo() ? "отмена выполнена" : "нечего отменять"));

        sb6.append(null);
        System.out.println(String.format("  append(null): '%s'", sb6));

        sb6.undo();
        System.out.println(String.format("  undo() после null: '%s'", sb6));
        System.out.println();

        System.out.println("[ТЕСТ 7] Работа с символами:");
        CustomStringBuilder sb7 = new CustomStringBuilder("Test");
        System.out.println(String.format("  Исходное: '%s'", sb7));
        System.out.println(String.format("  charAt(2): '%c'", sb7.charAt(2)));

        sb7.setCharAt(0, 'B');
        System.out.println(String.format("  setCharAt(0,'B'): '%s'", sb7));

        sb7.undo();
        System.out.println(String.format("  undo(): '%s'", sb7));
        System.out.println();

        System.out.println("=== ВСЕ ТЕСТЫ ЗАВЕРШЕНЫ ===");

    }
}