package corejava.inheritanceandreflection;

public class Rectangle {
	private Point topLeft;
	private double width;
	private double height;

	Rectangle(Point topLeft, double width, double height) {
		this.setTopLeft(topLeft);
		this.setWidth(width);
		this.setHeight(height);
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public Point getTopLeft() {
		return topLeft;
	}

	public void setTopLeft(Point topLeft) {
		this.topLeft = topLeft;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		super.clone();
		return new Rectangle((Point) topLeft.clone(), this.getWidth(), this.getHeight());
	}
}
