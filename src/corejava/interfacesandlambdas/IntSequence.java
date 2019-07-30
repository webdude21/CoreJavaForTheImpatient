package corejava.interfacesandlambdas;

class IntSequence {
  public static Sequence<Integer> of(int... sequance) {

    return new Sequence<Integer>() {

      int currentInt = 0;

      @Override
      public Integer next() {
        if (currentInt < sequance.length) {
          int result = sequance[currentInt];
          currentInt++;
          return result;
        } else {
          return null;
        }
      }

      @Override
      public boolean hasNext() {
        return currentInt < sequance.length;
      }
    };
  }

  public static Sequence<Integer> constant(int constant) {
    return new Sequence<Integer>() {
      @Override
      public Integer next() {
        return constant;
      }

      @Override
      public boolean hasNext() {
        return true;
      }
    };
  }
}
