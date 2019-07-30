package corejava.fundamentals;

class LargestSmallestFloat {
  public static void main(String[] args) {
    System.out.printf("Largest double = %f,\nSmallest double = %f", Math.nextDown(Double.MAX_VALUE), Math.nextUp(Double.MIN_VALUE));
  }
}
