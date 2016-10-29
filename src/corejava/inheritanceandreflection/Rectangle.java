package corejava.inheritanceandreflection;

class Rectangle {
	private Point topLeft;
	private double width;
	private double height;

	private Rectangle(Point topLeft, double width, double height) {
		this.setTopLeft(topLeft);
		this.setWidth(width);
		this.setHeight(height);
	}

	private double getHeight() {
		return height;
	}

	private void setHeight(double height) {
		this.height = height;
	}

	public Point getTopLeft() {
		return topLeft;
	}

	private void setTopLeft(Point topLeft) {
		this.topLeft = topLeft;
	}

	private double getWidth() {
		return width;
	}

	private void setWidth(double width) {
		this.width = width;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		super.clone();
		return new Rectangle((Point) topLeft.clone(), this.getWidth(), this.getHeight());
	}
}
