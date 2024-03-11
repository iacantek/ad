package ch.hslu.sw02.exercise4;

import org.junit.jupiter.api.Test;

import java.time.chrono.ChronoLocalDate;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class CharQueueTest {
    private static final byte ARRAY_SIZE = 8;

    @Test
    void testEnqueue() {
        // Arrange
        var queue = new CharQueue();

        // Assert
        assertDoesNotThrow(() -> queue.enqueue('x'));
    }

    @Test
    void testEnqueueFill() {
        // Arrange
        var queue = new CharQueue();

        // Act
        for (var i = 0; i < ARRAY_SIZE; i++) {
            queue.enqueue('x');
        }

        // Assert
        assertEquals(ARRAY_SIZE, queue.size());
        assertTrue(queue.full());
    }

    @Test
    void testEnqueueAlreadyFull() {
        // Arrange
        var queue = new CharQueue();

        // Act
        for (var i = 0; i < ARRAY_SIZE; i++) {
            queue.enqueue('x');
        }

        // Assert
        assertThrows(IndexOutOfBoundsException.class, () -> queue.enqueue('x'));
    }

    @Test
    void testDequeue() {
        // Arrange
        var queue = new CharQueue();
        queue.enqueue('x');

        // Act
        var item = queue.dequeue();

        // Assert
        assertEquals('x', item);
    }

    @Test
    void testDequeueThrowsException() {
        // Arrange
        var queue = new CharQueue();
        queue.enqueue('x');

        // Act
        queue.dequeue();

        // Assert
        assertThrows(IndexOutOfBoundsException.class, () -> queue.dequeue());
    }

    @Test
    void testFillAndEmpty() {
        // Arrange
        var queue = new CharQueue();

        // Act
        for (var i = 0; i < ARRAY_SIZE; i++) {
            queue.enqueue('x');
        }
        for (var i = 0; i < ARRAY_SIZE; i++) {
            queue.dequeue();
        }

        // Assert
        assertEquals(0, queue.size());
        assertTrue(queue.empty());
    }

    @Test
    void testToString() {
        // Arrange
        var queue = new CharQueue();

        // Act
        var string = queue.toString();
        var emptyArray = new char[ARRAY_SIZE];

        // Assert
        assertEquals("CharQueue{" +
                "head=" + 0 +
                ", tail=" + 0 +
                ", array=" + Arrays.toString(emptyArray) +
                '}', string);
    }
}