package ch.hslu.sw04.exercise4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HashTableTest {
    @Test
    void testInsert() {
        // arrange
        var table = new HashTable<Character>();

        // assert
        table.insert('a');

        // assert
        assertEquals('a', table.read(7));
    }

    @Test
    void testInsertSameHash() {
        // arrange
        var table = new HashTable<Character>();

        // act
        table.insert('a'); // index: 7 (hash code % 10)
        table.insert('k'); // index: 7 (hash code % 10)

        // assert
        assertEquals('k', table.read(7, 1));
    }

    @Test
    void testRemove() {
        // arrange
        var table = new HashTable<Character>();
        table.insert('a'); // index: 7 (hash code % 10)

        // act
        var success = table.remove('a');

        // assert
        assertTrue(success);
    }

    @Test
    void testRemoveFollowUp() {
        // arrange
        var table = new HashTable<Character>();
        table.insert('a'); // index: 7 (hash code % 10)
        table.insert('k'); // index: 7 (hash code % 10)

        // act
        var success = table.remove('k');

        // assert
        assertTrue(success);
    }

    @Test
    void testRemoveDoesNotExist() {
        // arrange
        var table = new HashTable<Character>();
        table.insert('a'); // index: 7 (hash code % 10)

        // act
        var success = table.remove('k');

        // assert
        assertFalse(success);
    }

    @Test
    void size() {
        // arrange
        var table = new HashTable<Character>();

        // assert
        assertEquals(10, table.size());
    }
}