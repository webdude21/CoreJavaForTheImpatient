package corejava.inheritanceandreflection;

abstract class Shape {

  private Point point;

  Shape(Point point) {
    this.point = point;
  }

  public void moveBy(double dx, double dy) {
    point.setX(point.getX() + dx);
    point.setY(point.getY() + dy);
  }

  public abstract Point getCenter();
}
