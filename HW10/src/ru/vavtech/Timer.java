package ru.vavtech;

import java.text.MessageFormat;
import java.util.List;

public class Timer {
    /**
     * Метод подсчитывает тайминги выполнения алгоритмов сортировки и выводит результаты в консоль
     *
     * @param algorithmName название алгоритма
     * @param sortAlgorithm реализация алгоритма сортировки
     * @param unorderedList список данных для теста
     */
    public void getTimings(String algorithmName, Sorting sortAlgorithm, List<Integer> unorderedList) {
        var startTime = System.nanoTime();
        var duration = (System.nanoTime() - startTime) / 1000;
        System.out.println(MessageFormat.format(
                "{0}. \nВремя выполнения: {1} микросекунд.", algorithmName, duration));
    }
}
