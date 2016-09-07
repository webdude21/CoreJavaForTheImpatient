package corejava.concurentprogramming;

import java.io.*;

class WordInFileFinder implements Runnable {

	private final File file;
	private final String searchWord;
	private Thread[] threads;

	WordInFileFinder(File file, String searchWord, Thread[] threads) {
		this.file = file;
		this.searchWord = searchWord;
		this.threads = threads;
	}

	private void stopOtherThreads() {
		for (Thread thread : threads) {
			thread.interrupt();
		}
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
			e.printStackTrace();
		}
		String currentLine;

		try {
			while ((currentLine = br.readLine()) != null) {
				if (Thread.currentThread().isInterrupted()) {
					return;
				}

				if (currentLine.contains(searchWord)) {
					stopOtherThreads();
					announceFileFound();
					return;
				}

				Thread.sleep(1);
			}
		} catch (IOException e) {
			System.out.println("Could't work with the file");
		} catch (InterruptedException e) {
			System.out.println("Interrupted");
		}
	}

	private void announceFileFound() {
		System.out.printf("Found '%s' in %s%n", searchWord, file.getPath());
	}
}
