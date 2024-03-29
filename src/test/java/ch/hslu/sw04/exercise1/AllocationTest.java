package ch.hslu.sw04.exercise1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AllocationTest {

    @Test
    void getValue() {
        // arrange
        final char value = 'h';
        var allocation = new Allocation<>(value);

        // act
        var getValue = allocation.getValue();

        // assert
        assertEquals(value, getValue);
    }

    @Test
    void testEquals() {
        // arrange
        var allocation1 = new Allocation<>('h');
        var allocation2 = new Allocation<>('h');

        // assert
        assertTrue(allocation1.equals(allocation2));
        assertTrue(allocation2.equals(allocation1));
    }

    @Test
    void testHashCode() {
        // arrange
        var allocation1 = new Allocation<>('h');
        var allocation2 = new Allocation<>('h');

        // assert
        assertEquals(allocation1.hashCode(), allocation2.hashCode());
    }

    @Test
    void testToString() {
        // arrange
        var allocation1 = new Allocation<>('h');

        // act
        var string = allocation1.toString();

        // assert
        assertEquals("Allocation{" +
                "value=h" +
                '}',
                string);
    }
}