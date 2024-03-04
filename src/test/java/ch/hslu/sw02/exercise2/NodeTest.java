package ch.hslu.sw02.exercise2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NodeTest {

    @Test
    void testGetValue() {
        // Arrange
        var node = new Node<>(0);

        // Act
        var value = node.getValue();

        // Assert
        assertEquals(0, value);
    }

    @Test
    void testGetNext() {
        // Arrange
        var node = new Node<>(0);
        var next = new Node<>(1);

        // Act
        node.setNext(next);

        assertEquals(next, node.getNext());
    }

    @Test
    void testSetNext() {
        // Arrange
        var node = new Node<>(0);
        var next = new Node<>(1);

        // Act
        node.setNext(next);

        // Assert
        assertNotNull(node.getNext());
    }

    @Test
    void testEquals() {
        // Arrange
        var node1 = new Node<>(0);
        var node2 = new Node<>(0);

        // Act
        var equals1 = node1.equals(node2);
        var equals2 = node2.equals(node1);

        // Assert
        assertTrue(equals1);
        assertTrue(equals2);
    }

    @Test
    void testHashCode() {
        // Arrange
        var node1 = new Node<>(0);
        var node2 = new Node<>(0);

        // Act
        var hashCode1 = node1.hashCode();
        var hashCode2 = node2.hashCode();

        // Assert
        assertEquals(hashCode1, hashCode2);
    }
}