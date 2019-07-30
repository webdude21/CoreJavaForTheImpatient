package corejava.generics;

public class Pair<E extends Comparable<E>> {

  private E firstElement;
  private E secondElement;

  public Pair(E firstElement, E secondElement) {
    setFirstElement(firstElement);
    setSecondElement(secondElement);
  }

  public E getFirstElement() {
    return firstElement;
  }

  private void setFirstElement(E firstElement) {
    this.firstElement = firstElement;
  }

  public E getSecondElement() {
    return secondElement;
  }

  private void setSecondElement(E secondElement) {
    this.secondElement = secondElement;
  }

  public E max() {
    return firstElement.compareTo(secondElement) > 0 ? firstElement : secondElement;
  }

  public E min() {
    return firstElement.compareTo(secondElement) < 0 ? firstElement : secondElement;
  }
}
