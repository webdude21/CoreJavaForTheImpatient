package corejava.interfacesandlambdas;

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

        while (intSequence.hasNext()){
            System.out.println(intSequence.next());
        }

        Sequence<Integer> constantSequence = IntSequence.constant(3);

        while (constantSequence.hasNext()){
            System.out.println(constantSequence.next());
        }
    }
}
