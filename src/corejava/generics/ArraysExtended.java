package corejava.generics;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ArraysExtended {

    public static void main(String[] args) {
        Integer[] arrayOne = {1, 2, 3};
        Integer[] arrayTwo = {4, 5};

        System.out.println(Arrays.toString(ArraysExtended.concat(arrayOne, arrayTwo)));
    }

    public static <T> T[] swap(int i, int j, T... values) {
        T temp = values[i];
        values[i] = values[j];
        values[j] = temp;
        return values;
    }

    public void test() {
        Double[] result = ArraysExtended.swap(0, 1, 1.5, 2d, 3d);
    }

    public static <T> T[] concat(T[] arrayOne, T[] arrayTwo) {
        @SuppressWarnings("unchecked")
        T[] resultArray = (T[]) Array.newInstance(arrayOne.getClass().getComponentType(), arrayOne.length + arrayTwo.length);
        System.arraycopy(arrayOne, 0, resultArray, 0, arrayOne.length);
        System.arraycopy(arrayTwo, 0, resultArray, arrayOne.length, arrayTwo.length);
        return resultArray;
    }
}
