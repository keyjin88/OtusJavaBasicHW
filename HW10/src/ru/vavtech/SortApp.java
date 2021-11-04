package ru.vavtech;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class SortApp {
    public static void main(String[] args) {
        //Переменные для отслеживания времени
        long currentTime;
        long timeAfterSort;
        List<Integer> testValues;

        System.out.println("Сравнительный анализ методов сортировки");

        System.out.println("Проверка быстродействия алгоритма сортировки пузырьком");
        currentTime = System.currentTimeMillis();
        testValues = createTestData();
        bubbleSort(testValues);
//        System.out.println("Результат: " + testValues);
        timeAfterSort = System.currentTimeMillis();
        System.out.println(MessageFormat.format("На сортировку пузырьком ушло: {0} сек.", (timeAfterSort - currentTime) / 1000));

        System.out.println("\n==============================\n");
        System.out.println("Проверка быстродействия алгоритма сортировки вставкой");
        currentTime = System.currentTimeMillis();
        testValues = createTestData();
        insertionSort(testValues);
//        System.out.println("Результат: " + testValues);
        timeAfterSort = System.currentTimeMillis();
        System.out.println(MessageFormat.format("На сортировку вставкой ушло: {0} сек.", (timeAfterSort - currentTime) / 1000));

        System.out.println("\n==============================\n");
        System.out.println("Проверка быстродействия алгоритма быстрой сортировки");
        currentTime = System.currentTimeMillis();
        testValues = createTestData();
        Collections.sort(testValues);
//        System.out.println("Результат: " + testValues);
        timeAfterSort = System.currentTimeMillis();
        System.out.println(MessageFormat.format("На быструю сортировку вставкой ушло: {0} сек.", (timeAfterSort - currentTime) / 1000));
    }

    private static List<Integer> createTestData() {
        List<Integer> testData = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 50000; i++) {
            testData.add(random.nextInt(0, 100));
        }
//        System.out.println("Тестовые данные: " + testData);
        return testData;
    }

    private static void bubbleSort(List<Integer> list) {
        do {
            int replaces = 0;
            for (int i = 1; i < list.size(); i++) {
                int curr = list.get(i);
                int prev = list.get(i - 1);
                if (curr < prev) {
                    list.set(i - 1, curr);
                    list.set(i, prev);
                    replaces++;
                }
            }

            if (replaces == 0) {
                break;
            }
        } while (true);
    }

    private static void insertionSort(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            Integer current = list.get(i);
            Integer minValue = current;
            int min = i;
            for (int j = i + 1; j < list.size(); j++) {
                Integer iterElem = list.get(j);
                if (minValue > iterElem) {
                    minValue = iterElem;
                    min = j;
                }
            }
            list.set(i, list.get(min));
            list.set(min, current);
        }
    }
}
