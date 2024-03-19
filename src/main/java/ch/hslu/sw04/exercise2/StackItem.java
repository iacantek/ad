package ch.hslu.sw04.exercise2;

public class StackItem<T> {
    private final Integer previousItemIndex;
    private final T value;

    public StackItem(T value, Integer previousItemIndex) {
        this.value = value;
        this.previousItemIndex = previousItemIndex;
    }

    public Integer getPreviousItemIndex() {
        return previousItemIndex;
    }

    public T getValue() {
        return value;
    }
}
