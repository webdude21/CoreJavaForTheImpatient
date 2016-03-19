package corejava.interfacesandlambdas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class LuckySort {

    void sort(ArrayList<String> strings, Comparator<String> comp) {
        while (!isSorted(strings, comp)) {
            Collections.shuffle(strings);
        }
    }

    private boolean isSorted(ArrayList<String> strings, Comparator<String> comp) {
        String prev = null;
        for (String elem : strings) {
            if (prev != null && comp.compare(prev, elem) > 0) {
                return false;
            }
            prev = elem;
        }
        return true;
    }
}
