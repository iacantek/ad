package ch.hslu.sw04.exercise1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class HashTableTest {
    @Test
    void testInsert() {
        // arrange
        var table = new HashTable<Character>();

        // act
        table.insert('a');

        // assert
        assertEquals(1, table.allocatedSize());
    }

    @Test
    void testInsertOverride() {
        // arrange
        var table = new HashTable<Character>();

        // act
        table.insert('a'); // index: 7 (hash code % 10)
        table.insert('k'); // index: 7 (hash code % 10)

        // assert
        assertNotEquals('a', table.read(7));
        assertEquals('k', table.read(7));
    }

    @Test
    void testRead() {
        // arrange
        final Character insertValue = 'a';
        var table = new HashTable<Character>();
        table.insert(insertValue);

        // act
        var hash = insertValue.hashCode() % table.size();
        var readValue = table.read(hash);

        // assert
        assertEquals(insertValue, readValue);
    }

    @Test
    void testToString() {
        // arrange
        var table = new HashTable<Character>();

        // act
        table.insert('a');

        // assert
        assertEquals("HashTable{" +
                "table=[null, null, null, null, null, null, null, Allocation{value=a}, null, null]" +
                '}',
                table.toString());
    }
}