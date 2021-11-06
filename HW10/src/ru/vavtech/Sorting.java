package ru.vavtech;

import java.util.List;

public interface Sorting {
    /**
     * Метод вовзращает отсортированый список
     *
     * @param unorderedList список для сортировки
     * @return отсортированый список
     */
    List<Integer> sort(List<Integer> unorderedList);
}
