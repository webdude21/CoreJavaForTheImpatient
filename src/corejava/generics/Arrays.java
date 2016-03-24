package corejava.generics;

public class Arrays {

    public static <T> T[] swap(int i, int j, T... values) {
        T temp = values[i];
        values[i] = values[j];
        values[j] = temp;
        return values;
    }

    public void test() {
        Double[] result = Arrays.swap(0, 1, 1.5, 2d, 3d);
    }

    public <T> void concat(T[] arrayOne, T[] arrayTwo) {

    }
}
