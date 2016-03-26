package corejava.streams;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Exercises {

    public static void main(String[] args) {
        Stream<String> streamOfWords = Stream.of("Long Long Word", "Shorter word", "short word", "letter");
        streamOfWords
                .filter(s -> s.length() > 7)
                .peek(System.out::println)
                .collect(Collectors.toList());
        streamOfWords = Stream.of("Long Long Word", "Shorter word", "short word", "letter");
        streamOfWords.parallel()
                .peek(x -> System.out.println(System.currentTimeMillis()))
                .allMatch(s -> s.length() > 2);
    }
}
