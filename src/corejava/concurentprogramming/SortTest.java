package corejava.concurentprogramming;

import java.util.Arrays;
import java.util.Random;

class SortTest {

	private final long[] testArray;

	private enum SortType {
		Parallel, Sequential
	}

	private int itemCountToTestWith;
	private Random random;

	private SortTest(int itemCountToTestWith, Random random) {
		this.itemCountToTestWith = itemCountToTestWith;
		this.random = random;
		testArray = getTestArray();
	}

	static void test(int count){
		SortTest sortTest = new SortTest(count, new Random());
		sortTest.parallelSort();
		sortTest.sequentialSort();
	}

	private void parallelSort() {
		long[] arrayCopy = getTestArrayCopy();
		timeTest(() -> Arrays.parallelSort(arrayCopy), SortType.Parallel);
	}

	private void sequentialSort() {
		long[] arrayCopy = getTestArrayCopy();
		timeTest(() -> Arrays.sort(arrayCopy), SortType.Sequential);
	}

	private long[] getTestArrayCopy(){
		return Arrays.copyOf(testArray, itemCountToTestWith);
	}

	private long[] getTestArray() {
		long[] resultArray = new long[itemCountToTestWith];

		for (int i = 0; i < itemCountToTestWith; i++) {
			resultArray[i] = random.nextLong();
		}

		return resultArray;
	}

	private void timeTest(Runnable runnable, SortType sortType) {
		long startTime = System.currentTimeMillis();
		runnable.run();
		long finishTime = System.currentTimeMillis();
		System.out.printf("%s sort took %s ms %n", sortType, finishTime - startTime);
	}
}
