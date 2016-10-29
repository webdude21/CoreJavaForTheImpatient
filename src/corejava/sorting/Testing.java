package corejava.sorting;

import java.util.Arrays;

public class Testing {
	private static Sorter insertionSort = new InsertionSort();
	public static void main(String[] args) {

		printSorted(new Integer[]{1, 4, 8, 5, 2, 4, 6, 3});
		printSorted(new String[]{"d", "c", "a", "b"});
	}

	static <T extends Comparable<T>> void printSorted(T[] toSort) {
		insertionSort.sort(toSort);
		System.out.println(Arrays.toString(toSort));
	}
}
