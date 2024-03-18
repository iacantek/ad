package ch.hslu.sw04.exercise3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AllocationTest {

    @Test
    void getValue() {
        // arrange
        var allocation = new Allocation<>('a');

        // act
        var value = allocation.getValue();

        // assert
        assertEquals('a', value);
    }

    @Test
    void isGrave() {
        // arrange
        var allocation = new Allocation<>('a');

        // assert
        assertFalse(allocation.isGrave());
    }

    @Test
    void setIsGrave() {
        // arrange
        var allocation = new Allocation<>('a');

        // act
        allocation.setGrave();

        // assert
        assertTrue(allocation.isGrave());
    }

    @Test
    void testEquals() {
        // arrange
        var allocation1 = new Allocation<>('a');
        var allocation2 = new Allocation<>('a');

        // assert
        assertTrue(allocation1.equals(allocation2));
        assertTrue(allocation2.equals(allocation1));
    }

    @Test
    void testEqualsIsGrave() {
        // arrange
        var allocation1 = new Allocation<>('a');
        var allocation2 = new Allocation<>('a');
        allocation1.setGrave();
        allocation2.setGrave();

        // assert
        assertTrue(allocation1.equals(allocation2));
        assertTrue(allocation2.equals(allocation1));
    }

    @Test
    void testHashCode() {
        // arrange
        var allocation1 = new Allocation<>('a');
        var allocation2 = new Allocation<>('a');

        // assert
        assertEquals(allocation1.hashCode(), allocation2.hashCode());
    }

    @Test
    void testHashCodeIsGrave() {
        // arrange
        var allocation1 = new Allocation<>('a');
        var allocation2 = new Allocation<>('a');
        allocation1.setGrave();
        allocation2.setGrave();

        // assert
        assertEquals(allocation1.hashCode(), allocation2.hashCode());
    }

    @Test
    void testToString() {
        // arrange
        var allocation = new Allocation<>('a');

        // act
        var string = allocation.toString();

        // assert
        assertEquals("Allocation{" +
                "value=a" +
                ", isGrave=false" +
                '}',
                string);
    }
}