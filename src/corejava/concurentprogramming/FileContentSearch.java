package corejava.concurentprogramming;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

class FileContentSearch {

	private final String searchWord;

	private final String searchPath;

	FileContentSearch(String searchWord, String searchPath) {
		this.searchWord = searchWord;
		this.searchPath = searchPath;
	}

	void search() {
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

	private boolean contains(String word, File file) {
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			return br.lines().anyMatch(x -> x.contains(word));
		} catch (IOException e) {
			return false;
		}
	}

	private Stream<File> getFiles(String path) {
		return Arrays.stream(new File(path).listFiles());
	}
}
