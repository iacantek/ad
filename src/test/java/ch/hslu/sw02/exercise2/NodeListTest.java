package ch.hslu.sw02.exercise2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NodeListTest {

    @Test
    void testAdd() {
        // Arrange
        var list = new NodeList<>();

        // Act
        list.add(0);

        // Assert
        assertEquals(1, list.size());
    }

    @Test
    void testSize() {
        // Arrange
        var list = new NodeList<>();

        // Act
        list.add(0);
        list.add(1);

        // Assert
        assertEquals(2, list.size());
    }

    @Test
    void testContains() {
        // Arrange
        var list = new NodeList<>();
        list.add(0);

        // Act
        var contains = list.contains(0);

        // Assert
        assertTrue(contains);
    }

    @Test
    void testContainsNot() {
        // Arrange
        var list = new NodeList<>();
        list.add(0);

        // Act
        var contains = list.contains(1);

        // Assert
        assertFalse(contains);
    }

    @Test
    void testShift() {
        // Arrange
        var list = new NodeList<>();
        list.add(0);
        list.add(1);

        // Act
        list.shift();

        // Assert
        assertEquals(1, list.size());
    }

    @Test
    void testRemove() {
        // Arrange
        var list = new NodeList<>();
        list.add(0);
        list.add(1);
        list.add(2);

        // Act
        list.remove(2);

        // Assert
        assertEquals(2, list.size());
    }
}