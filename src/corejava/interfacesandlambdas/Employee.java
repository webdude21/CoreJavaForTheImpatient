package corejava.interfacesandlambdas;

import java.util.Arrays;
import java.util.OptionalDouble;

public class Employee implements Measurable {

	private double wage;

	public Employee(double wage) {
		this.wage = wage;
	}

	public static double average(Measurable[] objects) {
		OptionalDouble result = Arrays.stream(objects).mapToDouble(Measurable::getMeasurable).average();
		return result.isPresent() ? result.getAsDouble() : 0d;
	}

	public static double largest(Measurable[] objects) {
		return Arrays.stream(objects).mapToDouble(Measurable::getMeasurable).max().getAsDouble();
	}

	@Override
	public double getMeasurable() {
		return wage;
	}
}
