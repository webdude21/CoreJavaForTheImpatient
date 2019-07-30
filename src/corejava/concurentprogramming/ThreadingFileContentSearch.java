package corejava.concurentprogramming;

import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;

class ThreadingFileContentSearch extends FileContentFinder {

  private AtomicBoolean resultFound = new AtomicBoolean(false);

  ThreadingFileContentSearch(String searchWord, String searchPath) {
    super(searchWord, searchPath);
  }

  @Override
  public void search() {
    File[] files = this.getFilesAsArray();
    Thread[] threads = new Thread[files.length];

    for (int i = 0; i < files.length; i++) {
      threads[i] = new Thread(new WordInFileFinder(files[i], searchWord, resultFound));
    }

    System.out.println("Threads are ready to run");

    for (Thread thread : threads) {
      thread.start();
      System.out.printf("%s started ...%n", thread.getName());
    }
  }
}
