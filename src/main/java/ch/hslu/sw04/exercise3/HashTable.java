package ch.hslu.sw04.exercise3;

import java.util.Arrays;

public class HashTable<T> implements IHashTable<T> {
    private static final int TABLE_SIZE = 10;

    private final Allocation<T>[] table = new Allocation[TABLE_SIZE];
    private int allocatedSize = 0;

    @Override
    public boolean insert(final T value) {
        var allocation = new Allocation<>(value);
        var index = this.getIndex(value);

        var start = index;
        var slot = this.table[index];

        while (slot != null && !slot.isGrave()) { // slot is occupied and not a gravestone
            index++;
            if (index == TABLE_SIZE) { // reached end of array, continue searching at beginning
                index = 0;
            }
            if (index == start) { // no empty slot was found, array is already full
                return false;
            }

            slot = this.table[index];
        }

        this.table[index] = allocation;
        this.allocatedSize++;
        return true;
    }

    @Override
    public T read(final int hash) {
        return this.table[hash].getValue();
    }

    @Override
    public Integer search(final T value) {
        var index = this.getIndex(value);
        var start = index;
        var slot = this.table[index];

        if (slot == null) return null;

        while (slot != null && (!slot.getValue().equals(value) || slot.isGrave())) {
            index++;
            if (index == TABLE_SIZE) { // reached end of array, continue searching at beginning
                index = 0;
            }
            if (index == start) { // no empty slot was found, array is already full
                return null;
            }

            slot = this.table[index];
        }

        return index;
    }

    @Override
    public boolean remove(final T value) {
        var index = this.search(value);
        var exists = index != null;

        if (exists) this.table[index].setGrave();

        return exists;
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

    private int getIndex(final T value) {
        return value.hashCode() % TABLE_SIZE;
    }
}
