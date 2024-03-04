package ch.hslu.sw02.exercise2;

public class NodeList<T> {
    private Node<T> start;
    private Node<T> end;

    public void add(T item) {
        var node = new Node<>(item);

        if (this.start == null) { // first allocation automatically is start and end
            this.start = node;
            this.end = this.start;
            return;
        }

        var currentStart = this.start;

        this.start = node;
        this.start.setNext(currentStart);
    }

    public int size() {
        if (this.start == null) return 0;

        int counter = 0;
        var currentAllocation = this.start;

        do {
            counter++;
            currentAllocation = currentAllocation.getNext();
        } while (currentAllocation != null);

        return counter;
    }

    public boolean contains(T item) {
        return this.find(item) != null;
    }

    public T shift() {
        if (this.start == null) return null;

        var firstNode = this.start;
        this.start = firstNode.getNext();

        return firstNode.getValue();
    }

    public void remove(T item) {
        if (this.start == null) return;

        var currentAllocation = this.start;
        Node<T> previousAllocation = null;

        do {
            if (currentAllocation.getValue().equals(item)) {
                if (previousAllocation == null) {
                    // setting the next item as start if the first item is a match
                    this.start = currentAllocation.getNext();
                }
                else {
                    // skip removed allocation by setting the next item of it
                    // to the next item of the previous item
                    previousAllocation.setNext(currentAllocation.getNext());
                }
                return;
            }
            currentAllocation = currentAllocation.getNext();
            previousAllocation = currentAllocation;
        } while (currentAllocation != null);
    }

    private T find(T item) {
        if (this.start == null) return null;

        var currentAllocation = this.start;

        do {
            var value = currentAllocation.getValue();
            if (value.equals(item)) return value;
            currentAllocation = currentAllocation.getNext();
        } while (currentAllocation != null);

        return null;
    }
}
