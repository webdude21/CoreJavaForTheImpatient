package corejava.streams;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.stream.Stream;

public class FileStreams {

    private static final String pathToRead = "/usr/share/dict/words";

    public static void main(String[] args) {

        try {
            findMaxLength(getStreamFromFile(pathToRead));
            findAverageLength(getStreamFromFile(pathToRead));
            findWordsWithOnlyUniqueLetters(getStreamFromFile(pathToRead));
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private static Stream<String> getStreamFromFile(String filePath) throws FileNotFoundException {
        return new BufferedReader(new FileReader(filePath)).lines();
    }

    private static void findWordsWithOnlyUniqueLetters(Stream<String> linesStream) {
        linesStream.filter(FileStreams::filterDistinctWords).forEach(System.out::println);
    }

    private static void findAverageLength(Stream<String> linesStream) {
        linesStream.mapToInt(String::length).average().ifPresent(System.out::println);
    }

    private static void findMaxLength(Stream<String> linesStream) {
        linesStream.mapToInt(String::length).max().ifPresent(System.out::println);
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
