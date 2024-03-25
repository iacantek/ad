package ch.hslu.sw04.exercise3;

import java.util.Objects;

public class Allocation<T> {
    private final T value;
    private boolean isGrave = false;

    public Allocation(final T value) {
        this.value = value;
    }

    public T getValue() {
        return this.value;
    }

    public boolean isGrave() {
        return this.isGrave;
    }

    public void setGrave() {
        this.isGrave = true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Allocation<?> allocation = (Allocation<?>) o;
        return isGrave == allocation.isGrave && Objects.equals(value, allocation.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, isGrave);
    }

    @Override
    public String toString() {
        return "Allocation{" +
                "value=" + value +
                ", isGrave=" + isGrave +
                '}';
    }
}
