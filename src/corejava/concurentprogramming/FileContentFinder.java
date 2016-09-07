package corejava.concurentprogramming;

import java.io.File;
import java.util.Arrays;
import java.util.stream.Stream;

abstract class FileContentFinder {
	final String searchWord;
	private final String searchPath;

	FileContentFinder(String searchWord, String searchPath) {
		this.searchPath = searchPath;
		this.searchWord = searchWord;
	}

	public abstract void search();

	Stream<File> getFiles() {
		return Arrays.stream(new File(searchPath).listFiles());
	}

	File[] getFilesAsArray() {
		return new File(searchPath).listFiles();
	}
}
