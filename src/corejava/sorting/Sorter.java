package corejava.sorting;

public interface Sorter {
	<T extends Comparable<T>> void sort(T[] thingsToSort);
}
