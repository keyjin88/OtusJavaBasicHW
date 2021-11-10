package ru.vavtech;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QuickSorting implements Sorting {

    @Override
    public List<Integer> sort(List<Integer> unorderedList) {
        var orderedList = new ArrayList<>(unorderedList);
        Collections.sort(orderedList);
        return orderedList;
    }
}
