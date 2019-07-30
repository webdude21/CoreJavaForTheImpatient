package corejava.concurentprogramming;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
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
      while ((currentLine = br.readLine()) != null && !resultFound.get()) {
        if (currentLine.contains(searchWord)) {
          resultFound.set(true);
          announceFileFound();
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
