package corejava.interfacesandlambdas;

import java.util.ArrayList;
import java.util.Random;
import java.util.stream.IntStream;

public class Testing {
    public static void main(String[] args) {
        Random randomGenerator = new Random();
        Measurable[] measurables = new Measurable[10];

        IntStream.range(0, measurables.length).forEach(i -> measurables[i] = new Employee(randomGenerator.nextDouble() * 100d));

        System.out.printf("Average wage: %f%n", Employee.avarage(measurables));
        System.out.printf("Largest wage: %f%n", Employee.largest(measurables));

        Sequence<Integer> intSequence = IntSequence.of(1, 2, 3, 4, 5, 6);

        while (intSequence.hasNext()) {
            System.out.println(intSequence.next());
        }

        LuckySort luckySort = new LuckySort();

        ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add("pesho");
        arrayList.add("abv");
        arrayList.add("gosho");

        luckySort.sort(arrayList, String::compareTo);
        System.out.println(String.join(", ", arrayList));

        luckySort.sort(arrayList, (a, b) -> b.compareTo(a));
        System.out.println(String.join(", ", arrayList));
    }
}
