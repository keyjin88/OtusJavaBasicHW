package ru.vavtech;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SortApp {
    public static void main(String[] args) {
        var timer = new Timer();
        var testValues = createTestData();

        System.out.println("Сравнительный анализ методов сортировки");
        timer.getTimings("Сортировка пузырьком", new BubbleSorting(), testValues);
        timer.getTimings("Сортировка вставкой", new InsertionSorting(), testValues);
        timer.getTimings("Быстрая сортировка", new QuickSorting(), testValues);
    }

    private static List<Integer> createTestData() {
        var testData = new ArrayList<Integer>();
        var random = new Random();
        for (int i = 0; i < 5000; i++) {
            testData.add(random.nextInt(0, 100));
        }
        return testData;
    }
}
