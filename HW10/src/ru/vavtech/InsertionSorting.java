package ru.vavtech;

import java.util.ArrayList;
import java.util.List;

public class InsertionSorting implements Sorting {

    @Override
    public List<Integer> sort(List<Integer> unorderedList) {
        var orderedList = new ArrayList<>(unorderedList);
        for (int i = 0; i < orderedList.size(); i++) {
            Integer current = orderedList.get(i);
            Integer minValue = current;
            int min = i;
            for (int j = i + 1; j < orderedList.size(); j++) {
                Integer iterElem = orderedList.get(j);
                if (minValue > iterElem) {
                    minValue = iterElem;
                    min = j;
                }
            }
            orderedList.set(i, orderedList.get(min));
            orderedList.set(min, current);
        }
        return orderedList;
    }
}
