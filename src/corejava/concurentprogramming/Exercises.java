package corejava.concurentprogramming;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

public class Exercises {

	public static void main(String[] args) {
		searchForTextInPath("Array", "src/corejava/generics");
	}

	private static void searchForTextInPath(String searchWord, String searchPath) {
		Optional<File> file = getFiles(searchPath)
				.parallel()
				.peek(x -> System.out.printf("Looking into file %s%n", x.getPath()))
				.filter(x -> contains(searchWord, x))
				.findFirst();

		if (file.isPresent()) {
			System.out.printf("Found '%s' in %s", searchWord, file.get().getPath());
		} else {
			System.out.printf("No file found that contains: '%s'", searchWord);
		}
	}

	private static boolean contains(String word, File file) {
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			return br.lines().anyMatch(x -> x.contains(word));
		} catch (IOException e) {
			return false;
		}
	}

	private static Stream<File> getFiles(String path) {
		return Arrays.stream(new File(path).listFiles());
	}
}
