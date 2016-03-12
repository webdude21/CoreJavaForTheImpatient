package corejava.fundamentals;

import java.util.Arrays;
import java.util.Scanner;

public class MaxOfThree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] input = new int[3];

        for (int i = 0; i < input.length; i++) {
            input[i] = scanner.nextInt();
        }

        System.out.println(Arrays.stream(input).max().getAsInt());
    }
}
