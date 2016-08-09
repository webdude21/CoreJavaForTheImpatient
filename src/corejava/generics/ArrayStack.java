package corejava.generics;

public class ArrayStack<E> implements Stack<E> {

	private static final int DEFAULT_CAPACITY = 100;
	private static final int GROWING_FACTOR = 2;
	private E[] array;
	private int index = 0;

	public ArrayStack() {
		this(DEFAULT_CAPACITY);
	}

	public ArrayStack(int capacity) {
		array = (E[]) new Object[capacity];
	}

	@Override
	public void push(E element) {
		this.growIfNeeded();
		this.array[index++] = element;
	}

	@Override
	public E pop() {
		checkIfStackIsEmpty();
		return this.array[--index];
	}

	private void checkIfStackIsEmpty() {
		if (this.index < 1) {
			throw new IllegalStateException("Cannot do this on an empty stack");
		}
	}

	@Override
	public boolean isEmpty() {
		return index == 0;
	}

	@Override
	public E peek() {
		checkIfStackIsEmpty();
		return array[index - 1];
	}

	private void growIfNeeded() {
		if (this.index < this.array.length) {
			return;
		}

		E[] oldArray = this.array;
		this.array = (E[]) new Object[oldArray.length * GROWING_FACTOR];
		System.arraycopy(oldArray, 0, this.array, 0, oldArray.length);
	}
}
