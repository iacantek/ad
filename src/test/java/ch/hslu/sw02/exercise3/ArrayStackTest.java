package ch.hslu.sw02.exercise3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayStackTest {
    @Test
    void testConstructor() {
        // Arrange, Act & Assert
        assertThrows(IllegalArgumentException.class, () -> new ArrayStack(0));
    }

    @Test
    void testGetAllocatedSize() {
        // Arrange
        var stack = new ArrayStack(1);

        // Act

        // Assert
        assertEquals(1, stack.getAllocatedSize());
    }

    @Test
    void testPushThrowsException() {
        // Arrange
        var stack = new ArrayStack(1);

        // Act
        stack.push("First item");

        // Assert
        assertThrows(IndexOutOfBoundsException.class, () -> stack.push("Second item"));
    }

    @Test
    void testPop() {
        // Arrange
        var stack = new ArrayStack(1);

        // Act
        stack.push("First item");
        var top = stack.pop();

        // Assert
        assertNotNull(top);
        assertEquals("First item", top);
    }

    @Test
    void testPopNull() {
        // Arrange
        var stack = new ArrayStack(1);

        // Act
        var top = stack.pop();

        // Assert
        assertNull(top);
    }

    @Test
    void testIsFull() {
        // Arrange
        var stack = new ArrayStack(1);

        // Act
        stack.push("First item");

        // Assert
        assertTrue(stack.isFull());
    }

    @Test
    void testIsNotFull() {
        // Arrange
        var stack = new ArrayStack(1);

        // Act

        // Assert
        assertFalse(stack.isFull());
    }
}