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
        if (arrayList.size() < 1) {
            throw new IllegalStateException("Cannot use pop on an empty stack");
        }
        return this.arrayList.remove(arrayList.size() - 1);
    }

    @Override
    public boolean isEmpty() {
        return this.arrayList.isEmpty();
    }

    @Override
    public E peek() {
        return this.arrayList.get(arrayList.size() - 1);
    }
}
