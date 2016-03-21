package corejava.fundamentals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrintAllSubStrings {

    public static void main(String[] args) {
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        String input = null;
        try {
            input = buffer.readLine();
        } catch (IOException e) {
            System.out.println("An error occurred during the reading from the console stream");
        }

        assert input != null;

        for (int i = 0; i <= input.length(); i++) {
            for (int j = 0; i + j <= input.length(); j++) {
                String output = input.substring(i, i + j);
                if (!output.isEmpty()) {
                    System.out.println(output);
                }
            }
        }
    }
}
