package corejava.concurentprogramming;

import java.io.File;

class ThreadingFileContentSearch extends FileContentFinder {

	ThreadingFileContentSearch(String searchWord, String searchPath) {
		super(searchWord, searchPath);
	}

	@Override
	public void search() {
		File[] files = this.getFilesAsArray();
		Thread[] threads = new Thread[files.length];

		for (int i = 0; i < files.length; i++) {
			threads[i] = new Thread(new WordInFileFinder(files[i], searchWord, threads));
		}

		System.out.println("Threads are ready to run");

		for (Thread thread : threads) {
			thread.start();
		}
	}
}
