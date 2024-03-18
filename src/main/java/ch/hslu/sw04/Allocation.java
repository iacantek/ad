package ch.hslu.sw04;

import java.util.Objects;

public class Allocation<T> {
    private final T value;

    public Allocation(T value) {
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
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    @Override
    public String toString() {
        return "Allocation{" +
                "value=" + value +
                '}';
    }
}
