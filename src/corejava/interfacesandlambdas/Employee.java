package corejava.interfacesandlambdas;

import java.util.Arrays;

public class Employee implements Measurable {

  private double wage;

  public Employee(double wage) {
    this.wage = wage;
  }

  public static double average(Measurable[] objects) {
    return Arrays.stream(objects).mapToDouble(Measurable::getMeasurable).average().orElse(0);
  }

  public static double largest(Measurable[] objects) {
    return Arrays.stream(objects).mapToDouble(Measurable::getMeasurable).max().orElse(0);
  }

  @Override
  public double getMeasurable() {
    return wage;
  }
}
