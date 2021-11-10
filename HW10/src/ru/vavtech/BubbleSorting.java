package ru.vavtech;

import java.util.ArrayList;
import java.util.List;

public class BubbleSorting implements Sorting {
    @Override
    public List<Integer> sort(List<Integer> list) {
        var orderedList = new ArrayList<>(list);
        do {
            int replaces = 0;
            for (int i = 1; i < orderedList.size(); i++) {
                int curr = orderedList.get(i);
                int prev = orderedList.get(i - 1);
                if (curr < prev) {
                    orderedList.set(i - 1, curr);
                    orderedList.set(i, prev);
                    replaces++;
                }
            }

            if (replaces == 0) {
                break;
            }
        } while (true);
        return orderedList;
    }
}
