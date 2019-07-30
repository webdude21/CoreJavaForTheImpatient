package corejava.generics;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

class ArraysExtended {

  public static void main(String[] args) {
    Integer[] arrayOne = {1, 2, 3};
    Integer[] arrayTwo = {4, 5};

    System.out.println(Arrays.toString(ArraysExtended.concat(arrayOne, arrayTwo)));
  }

  private static <T> T[] swap(int i, int j, T... values) {
    T temp = values[i];
    values[i] = values[j];
    values[j] = temp;
    return values;
  }

  private static <T> T[] concat(T[] arrayOne, T[] arrayTwo) {
    @SuppressWarnings("unchecked")
    T[] resultArray = (T[]) Array.newInstance(arrayOne.getClass().getComponentType(), arrayOne.length + arrayTwo.length);
    System.arraycopy(arrayOne, 0, resultArray, 0, arrayOne.length);
    System.arraycopy(arrayTwo, 0, resultArray, arrayOne.length, arrayTwo.length);
    return resultArray;
  }

  public static <E extends Comparable<E>> Pair<E> firstLast(ArrayList<E> list) {
    return new Pair<>(list.get(0), list.get(list.size() - 1));
  }

  private static <E extends Comparable<E>> E max(ArrayList<E> list) {
    return list.stream().max(Comparable::compareTo).orElse(list.get(0));
  }

  private static <E extends Comparable<E>> E min(ArrayList<E> list) {
    return list.stream().min(Comparable::compareTo).orElse(list.get(0))
  }

  public static <E extends Comparable<E>> Pair<E> minMax(ArrayList<E> list) {
    return new Pair<>(min(list), max(list));
  }

  public void test() {
    Double[] result = ArraysExtended.swap(0, 1, 1.5, 2d, 3d);
  }
}
