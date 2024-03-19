package ch.hslu.sw04.exercise2;

public class ArrayStack<T> implements IArrayStack<T> {
    private final StackItem<T>[] stackItems;
    private int currentIndex;

    public ArrayStack(final int allocatedSize) throws IllegalArgumentException {
        if (allocatedSize <= 0) {
            throw new IllegalArgumentException("The stack must be able to at least hold one item!");
        }

        this.stackItems = new StackItem[allocatedSize];
        this.currentIndex = 0;
    }

    @Override
    public int getAllocatedSize() {
        return stackItems.length;
    }

    @Override
    public void push(T item) throws IndexOutOfBoundsException {
        if (this.isFull()) throw new IndexOutOfBoundsException();

        this.stackItems[this.currentIndex] = new StackItem(item);
        this.currentIndex++;
    }

    @Override
    public T pop() {
        var topItem = this.stackItems[this.stackItems.length - 1];
        if (topItem == null) return null;

        this.stackItems[stackItems.length - 1] = null;
        this.currentIndex--;

        return topItem.getValue();
    }

    @Override
    public boolean isFull() {
        // if top item is not null
        return this.currentIndex == this.stackItems.length;
    }
}
