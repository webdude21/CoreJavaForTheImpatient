package corejava.streams;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.stream.Stream;

public class FileStreams {

    private static final String pathToRead = "/usr/share/dict/words";

    public static void main(String[] args) {
        try {
            BufferedReader targetStream = new BufferedReader(new FileReader(pathToRead));
            System.out.printf("Max length is: %d", findMaxLength(targetStream.lines()));
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void findWordsWithOnlyUniqueLetters(Stream<String> linesStream) {
        linesStream.filter(FileStreams::filterDistinctWords).forEach(System.out::println);
    }

    private static double findAverageLength(Stream<String> linesStream) {
        return linesStream.mapToInt(String::length).average().getAsDouble();
    }

    private static int findMaxLength(Stream<String> linesStream){
        return linesStream.mapToInt(String::length).max().getAsInt();
    }

    private static boolean filterDistinctWords(String str) {
        for (char ch : str.toCharArray()) {
            if (str.indexOf(ch) != str.lastIndexOf(ch)) {
                return false;
            }
        }
        return true;
    }
}
