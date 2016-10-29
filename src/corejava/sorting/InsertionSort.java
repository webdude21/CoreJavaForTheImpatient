package corejava.sorting;

class InsertionSort implements Sorter {

	public <T extends Comparable<T>> void sort(T[] thingsToSort) {
		for (int i = 1; i < thingsToSort.length; i++) {
			for (int j = i; j > 0; j--) {
				insert(thingsToSort, j);
			}
		}
	}

	private static <T extends Comparable<T>> void insert(T[] thingsToSort, int index) {
		if (shouldBeSwapped(thingsToSort, index)) {
			swap(index - 1, index, thingsToSort);
		}
	}

	private static <T extends Comparable<T>> boolean shouldBeSwapped(T[] thingsToSort, int index) {
		return thingsToSort[index - 1].compareTo(thingsToSort[index]) > 0;
	}

	private static void swap(int x, int y, Object[] nums) {
		Object temp = nums[x];
		nums[x] = nums[y];
		nums[y] = temp;
	}
}
