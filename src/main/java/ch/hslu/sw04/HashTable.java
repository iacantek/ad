package ch.hslu.sw04;

import java.util.Arrays;

public class HashTable<T> implements IHashTable<T> {
    private static final int TABLE_SIZE = 10;

    private final Allocation<T>[] table = new Allocation[TABLE_SIZE];
    private int allocatedSize = 0;

    @Override
    public void insert(T value) {
        var allocation = new Allocation<>(value);
        var index = allocation.hashCode() % table.length;
        this.table[index] = allocation;
        this.allocatedSize++;
    }

    @Override
    public T read(int hash) {
        return this.table[hash].getValue();
    }

    @Override
    public int getAllocatedSize() {
        return this.allocatedSize;
    }

    @Override
    public int getSize() {
        return TABLE_SIZE;
    }

    @Override
    public String toString() {
        return "HashTable{" +
                "table=" + Arrays.toString(table) +
                '}';
    }
}
