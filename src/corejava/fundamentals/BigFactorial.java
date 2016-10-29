package corejava.fundamentals;

import java.math.BigInteger;
import java.util.Scanner;

class BigFactorial {

	private static BigInteger one = BigInteger.valueOf(1);

	private static BigInteger calcFactorial(BigInteger input) {
		if (input.equals(one)) {
			return one;
		}

		return input.multiply(calcFactorial(input.subtract(one)));
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println(calcFactorial(scanner.nextBigInteger()));
	}
}
