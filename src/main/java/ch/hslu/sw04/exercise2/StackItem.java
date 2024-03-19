package ch.hslu.sw04.exercise2;

public class StackItem<T> {
    private final T value;

    public StackItem(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }
}
