package corejava.concurentprogramming;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Optional;

class FileContentSearch extends FileContentFinder {

  FileContentSearch(String searchWord, String searchPath) {
    super(searchWord, searchPath);
  }

  @Override
  public void search() {
    Optional<File> file = getFiles()
      .parallel()
      .peek(x -> System.out.printf("Looking into file %s%n", x.getPath()))
      .filter(x -> contains(searchWord, x))
      .findFirst();

    if (file.isPresent()) {
      System.out.printf("Found '%s' in %s%n", searchWord, file.get().getPath());
    } else {
      System.out.printf("No file found that contains: '%s%n'", searchWord);
    }
  }

  private boolean contains(String word, File file) {
    try (BufferedReader br = new BufferedReader(new FileReader(file))) {
      return br.lines().anyMatch(x -> x.contains(word));
    } catch (IOException e) {
      return false;
    }
  }
}
