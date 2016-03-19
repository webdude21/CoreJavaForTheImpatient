package corejava.interfacesandlambdas;

import java.util.Arrays;

public class Employee implements Measurable {

    private double wage;

    public Employee(double wage) {
        this.wage = wage;
    }

    @Override
    public double getMeasurable() {
        return wage;
    }

    public static double avarage(Measurable[] objects) {
        return Arrays.stream(objects).mapToDouble(Measurable::getMeasurable).average().getAsDouble();
    }

    public static double largest(Measurable[] objects) {
        return Arrays.stream(objects).mapToDouble(Measurable::getMeasurable).max().getAsDouble();
    }
}
