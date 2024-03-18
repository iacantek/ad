package ch.hslu.sw04.exercise1;

import java.util.Arrays;

public class HashTable<T> implements IHashTable<T> {
    private static final int TABLE_SIZE = 10;

    private final Allocation<T>[] table = new Allocation[TABLE_SIZE];
    private int allocatedSize = 0;

    @Override
    public void insert(final T value) {
        var allocation = new Allocation<>(value);
        var index = allocation.hashCode() % table.length;
        this.table[index] = allocation;
        this.allocatedSize++;
    }

    @Override
    public T read(final int hash) {
        return this.table[hash].getValue();
    }

    @Override
    public int allocatedSize() {
        return this.allocatedSize;
    }

    @Override
    public int size() {
        return TABLE_SIZE;
    }

    @Override
    public String toString() {
        return "HashTable{" +
                "table=" + Arrays.toString(table) +
                '}';
    }
}
