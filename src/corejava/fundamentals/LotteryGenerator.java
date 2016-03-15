package corejava.fundamentals;

import java.util.ArrayList;
import java.util.Comparator;

public class LotteryGenerator {

    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < 49; i++) {
            numbers.add(i + 1);
        }

        numbers.remove((int) (Math.random() * 48 + 1));

        numbers.sort(Comparator.naturalOrder());
        System.out.println(numbers);
    }
}
