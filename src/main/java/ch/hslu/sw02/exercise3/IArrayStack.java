package ch.hslu.sw02.exercise3;

public interface IArrayStack {
    /**
     * Gets allocated size of stack
     * @return Allocated stack size
     */
    int getAllocatedSize();

    /**
     * Puts an item "on top" of the stsack
     * @param item Item to add
     */
    void push(String item);

    /**
     * Removes the top item from the stack
     */
    String pop();

    /**
     * Returns whether stack is full or not
     * @return true or false
     */
    boolean isFull();
}
