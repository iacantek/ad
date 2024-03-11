package ch.hslu.sw02.exercise4;

import java.util.Arrays;

public class CharQueue implements ICharQueue {
    private static final byte ARRAY_SIZE = 8;

    private int head;
    private int tail;
    private final char[] array;

    public CharQueue() {
        this.head = 0;
        this.tail = 0;
        this.array = new char[ARRAY_SIZE];
    }

    @Override
    public void enqueue(char item) throws IndexOutOfBoundsException {
        if (this.full()) throw new IndexOutOfBoundsException("Array is full.");

        var index = this.nextIndex();

        this.array[index] = item;
        this.tail = index;
    }

    @Override
    public char dequeue() throws IndexOutOfBoundsException {
        if (this.empty()) throw new IndexOutOfBoundsException("Array is empty.");

        var item = this.array[this.head];
        this.array[this.head] = Character.MIN_VALUE;
        this.head = this.head == ARRAY_SIZE - 1 ? 0 : head + 1;

        return item;
    }

    @Override
    public int size() {
        int counter = 0;
        for (char item : array) {
            if (item != Character.MIN_VALUE) {
                counter++;
            }
        }

        return counter;
    }

    @Override
    public boolean empty() {
        return this.size() == 0;
    }

    @Override
    public boolean full() {
        return this.size() == ARRAY_SIZE;
    }

    @Override
    public String toString() {
        return "CharQueue{" +
                "head=" + head +
                ", tail=" + tail +
                ", array=" + Arrays.toString(array) +
                '}';
    }

    private int nextIndex() {
        if (this.empty() || this.tail == ARRAY_SIZE - 1) return 0;

        return this.tail + 1;
    }
}
