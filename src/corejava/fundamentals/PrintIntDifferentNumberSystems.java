package corejava.fundamentals;

import java.util.Scanner;

public class PrintIntDifferentNumberSystems {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        double reciprocal = (double) 1 / input;

        System.out.println(String.format("Binary: %s", Integer.toBinaryString(input)));
        System.out.println(String.format("Octal: %s", Integer.toOctalString(input)));
        System.out.println(String.format("Hex: %s", Integer.toHexString(input)));
        System.out.println(String.format("The reciprocal as double: %s", Double.toHexString(reciprocal)));
    }
}
