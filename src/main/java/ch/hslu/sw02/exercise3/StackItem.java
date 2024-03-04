package ch.hslu.sw02.exercise3;

public class StackItem {
    private final Integer previousItemIndex;
    private final String value;

    public StackItem(String value, Integer previousItemIndex) {
        this.value = value;
        this.previousItemIndex = previousItemIndex;
    }

    public Integer getPreviousItemIndex() {
        return previousItemIndex;
    }

    public String getValue() {
        return value;
    }
}
