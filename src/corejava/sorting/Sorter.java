package corejava.sorting;

interface Sorter {
  <T extends Comparable<T>> void sort(T[] thingsToSort);
}
