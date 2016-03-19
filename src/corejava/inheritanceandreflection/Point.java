package corejava.inheritanceandreflection;

import java.lang.reflect.Field;

public class Point {

    protected double x;
    protected double y;

    public Point(double x, double y) {
        this.setY(y);
        this.setX(x);
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for(Field field: this.getClass().getDeclaredFields()){
            try {
                sb.append(field.get(this));
                sb.append("\n");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Point point = (Point) o;

        return Double.compare(point.getX(), getX()) == 0 && Double.compare(point.getY(), getY()) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(getX());
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getY());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
