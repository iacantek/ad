package ch.hslu.sw04.exercise2;

public interface IArrayStack<T> {
    /**
     * Gets allocated size of stack
     * @return Allocated stack size
     */
    int getAllocatedSize();

    /**
     * Puts an item "on top" of the stsack
     * @param item Item to add
     */
    void push(T item);

    /**
     * Removes the top item from the stack
     */
    T pop();

    /**
     * Returns whether stack is full or not
     * @return true or false
     */
    boolean isFull();
}
