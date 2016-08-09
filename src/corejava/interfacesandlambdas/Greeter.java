package corejava.interfacesandlambdas;

import java.util.Arrays;

public class Greeter implements Runnable {

	private final int printCount;
	private String target;

	public Greeter(int printCount, String target) {
		this.printCount = printCount;
		this.target = target;
	}

	public static void runTogether(Runnable... tasks) {
		Arrays.stream(tasks).forEach(task -> new Thread(task).start());
	}

	public static void runInOrder(Runnable... tasks) {
		Arrays.stream(tasks).forEach(Runnable::run);
	}

	@Override
	public void run() {
		for (int i = 0; i < printCount; i++) {
			System.out.printf("Hello, %s%n", target);
		}
	}
}
