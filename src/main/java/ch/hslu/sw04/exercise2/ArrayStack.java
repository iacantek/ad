package ch.hslu.sw04.exercise2;

public class ArrayStack<T> implements IArrayStack<T> {
    private final StackItem<T>[] stackItems;

    public ArrayStack() {
        this(100_000);
    }

    public ArrayStack(final int allocatedSize) throws IllegalArgumentException {
        if (allocatedSize <= 0) {
            throw new IllegalArgumentException("The stack must be able to at least hold one item!");
        }

        this.stackItems = new StackItem[allocatedSize];
    }

    @Override
    public int getAllocatedSize() {
        return stackItems.length;
    }

    @Override
    public void push(T item) throws IndexOutOfBoundsException {
        if (this.isFull()) throw new IndexOutOfBoundsException();

        for (var i = 0; i < stackItems.length; i++) {
            if (stackItems[i] == null) {
                stackItems[i] = new StackItem(item, i == 0 ? null : i-1);
                return;
            }
        }
    }

    @Override
    public T pop() {
        var topItem = stackItems[stackItems.length - 1];
        if (topItem == null) return null;

        stackItems[stackItems.length - 1] = null;

        return topItem.getValue();
    }

    @Override
    public boolean isFull() {
        for (var i = 0; i < this.stackItems.length; i++) {
            if (stackItems[i] == null) {
                return false;
            }
        }

        return true;
    }
}
