package ch.hslu.sw02.exercise2;

import java.util.Objects;

public class Node<T> {
    private Node<T> next;
    private T value;

    public Node(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node<?> node = (Node<?>) o;
        return Objects.equals(next, node.next) && Objects.equals(value, node.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(next, value);
    }
}
