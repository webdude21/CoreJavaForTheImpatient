package corejava.inheritanceandreflection;

public class Line {
    private Point from;
    private Point to;

    public Line(Point from, Point to) {
        this.setFrom(from);
        this.setTo(to);
    }

    public Point getFrom() {
        return from;
    }

    public void setFrom(Point from) {
        this.from = from;
    }

    public Point getTo() {
        return to;
    }

    public void setTo(Point to) {
        this.to = to;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        super.clone();
        return new Line((Point) from.clone(), (Point) to.clone());
    }
}
