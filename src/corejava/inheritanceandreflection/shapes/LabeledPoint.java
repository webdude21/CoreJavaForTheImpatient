package corejava.inheritanceandreflection.shapes;

public class LabeledPoint extends Point {

    private String label;

    public LabeledPoint(String label, double x, double y) {
        super(x, y);
        this.setLabel(label);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        LabeledPoint that = (LabeledPoint) o;

        return getLabel() != null ? getLabel().equals(that.getLabel()) : that.getLabel() == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (getLabel() != null ? getLabel().hashCode() : 0);
        return result;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
