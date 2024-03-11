package ch.hslu.sw02.exercise4;

public interface ICharQueue {
    /**
     * Put an item at the end of a queue.
     */
    void enqueue(char item);

    /**
     * Takes the first item from a queue and returns it.
     * @return First queue item
     */
    char dequeue();

    /**
     * Gets size of queue.
     * @return Size of queue
     */
    int size();

    /**
     * Checks if queue is empty.
     * @return True if empty, else false
     */
    boolean empty();

    /**
     * Checks if queue is full.
     * @return True if full, else false
     */
    boolean full();
}
