package corejava.generics;

import java.util.ArrayList;

public class ListStack<E> implements Stack<E> {

  private final ArrayList<E> arrayList = new ArrayList<>();

  @Override
  public void push(E element) {
    this.arrayList.add(element);
  }

  @Override
  public E pop() {
    this.checkIfStackIsEmpty();
    return this.arrayList.remove(arrayList.size() - 1);
  }

  private void checkIfStackIsEmpty() {
    if (arrayList.size() < 1) {
      throw new IllegalStateException("Cannot use do this on an empty stack");
    }
  }

  @Override
  public boolean isEmpty() {
    return this.arrayList.isEmpty();
  }

  @Override
  public E peek() {
    this.checkIfStackIsEmpty();
    return this.arrayList.get(arrayList.size() - 1);
  }
}
