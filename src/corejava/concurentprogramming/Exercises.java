package corejava.concurentprogramming;

class Exercises {

  public static void main(String[] args) {
    fileSearch();
    //sortTest();
  }

  private static void fileSearch() {
    new FileContentSearch("Array", "src/corejava/generics").search();
    new ThreadingFileContentSearch("Array", "src/corejava/generics").search();
  }

  private static void sortTest() {
    for (int i = 10; i < 1_000_000_000; i *= 10) {
      System.out.printf("Testing with %d elements: %n", i);
      SortTest.test(i);
    }
  }
}
