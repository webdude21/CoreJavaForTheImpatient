package corejava.concurentprogramming;

import java.io.*;
import java.util.concurrent.atomic.AtomicBoolean;

class WordInFileFinder implements Runnable {

	private final File file;
	private final String searchWord;
	private AtomicBoolean resultFound;

	WordInFileFinder(File file, String searchWord, AtomicBoolean resultFound) {
		this.file = file;
		this.searchWord = searchWord;
		this.resultFound = resultFound;
	}

	@Override
	public void run() {
		BufferedReader br = null;

		if (file.isDirectory()) {
			return;
		}

		try {
			br = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) {
			System.out.printf("File was not found %s%n", file.getName());
		}

		String currentLine;

		try {
			while ((currentLine = br.readLine()) != null) {
				if (resultFound.get()) {
					System.out.printf("An answer has already been found, thread %s exiting ...%n",
							Thread.currentThread().getName());
					return;
				}

				if (currentLine.contains(searchWord)) {
					resultFound.set(true);
					announceFileFound();
					return;
				}
			}
		} catch (IOException e) {
			System.out.println("Could't work with the file");
		}
	}

	private void announceFileFound() {
		System.out.printf("Found '%s' in %s by thread %s%n", searchWord, file.getPath(), Thread.currentThread().getName());
	}
}
