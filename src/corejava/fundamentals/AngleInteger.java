package corejava.fundamentals;

import java.util.Scanner;

class AngleInteger {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int angle = scanner.nextInt();
		System.out.println(Math.floorMod(angle, 359));
	}
}
