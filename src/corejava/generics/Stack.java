package corejava.generics;

public interface Stack<E> {

    void push(E element);

    E pop();

    boolean isEmpty();

    E peek();
}
