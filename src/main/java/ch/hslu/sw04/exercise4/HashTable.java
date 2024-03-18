package ch.hslu.sw04.exercise4;

import java.util.Objects;

public class HashTable<T> implements IHashTable<T> {
    private static final int TABLE_SIZE = 10;

    private final Allocation<T>[] table = new Allocation[TABLE_SIZE];
    private final Object[] values = new Object[TABLE_SIZE];

    @Override
    public void insert(T value) {
        var allocation = new Allocation<>(value);
        var index = this.getIndex(value);

        var slot = this.table[index];
        if (slot == null) {
            this.table[index] = allocation;
            return;
        }

        while(slot.next != null) {
            slot = slot.next;
        }

        slot.next = allocation;
    }

    @Override
    public T read(int hash) {
        return read(hash, 0);
    }

    @Override
    public T read(int hash, int offset) {
        var allocation = this.table[hash];
        for (var i = 0; i < offset; i++) {
            if (allocation == null) return null;
            allocation = allocation.next;
        }

        return allocation.getValue();
    }

    @Override
    public boolean remove(T value) {
        var index = this.getIndex(value);
        var slot = this.table[index];
        if (slot.value.equals(value)) {
            slot = null;
            return true;
        }

        while (slot.next != null && !slot.next.value.equals(value)) {
            slot = slot.next;
        }
        if (slot.next == null) return false;

        slot.next = null;
        return true;
    }

    @Override
    public int size() {
        return TABLE_SIZE;
    }

    private int getIndex(final T value) {
        return value.hashCode() % TABLE_SIZE;
    }

    private class Allocation<T> {
        private final T value;
        private Allocation<T> next;

        public Allocation(final T value) {
            this.value = value;
        }

        public T getValue() {
            return this.value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Allocation<?> that = (Allocation<?>) o;
            return Objects.equals(value, that.value) && Objects.equals(next, that.next);
        }

        @Override
        public int hashCode() {
            return Objects.hash(value, next);
        }

        @Override
        public String toString() {
            return "Allocation{" +
                    "value=" + value +
                    ", next=" + next +
                    '}';
        }
    }
}
