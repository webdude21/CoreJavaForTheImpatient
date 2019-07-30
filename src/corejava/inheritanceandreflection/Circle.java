package corejava.inheritanceandreflection;

public class Circle extends Shape {
  private double radius;

  public Circle(Point center, double radius) {
    super(center);
    this.setRadius(radius);
  }

  public double getRadius() {
    return radius;
  }

  private void setRadius(double radius) {
    this.radius = radius;
  }

  @Override
  public Point getCenter() {
    return null;
  }
}
