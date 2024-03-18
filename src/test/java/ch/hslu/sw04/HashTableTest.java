package ch.hslu.sw04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HashTableTest {
    @Test
    void testInsert() {
        // arrange
        var table = new HashTable<String>();

        // act
        table.insert("hello");

        // assert
        assertEquals(1, table.getAllocatedSize());
    }

    @Test
    void testInsertOverride() {
        // arrange
        var table = new HashTable<String>();

        // act
        table.insert("hello"); // index: 2 (hash code % 10)
        table.insert("head"); // index: 2 (hash code % 10)

        // assert
        assertEquals("head", table.read(2));
    }

    @Test
    void testRead() {
        // arrange
        final String insertValue = "hello";
        var table = new HashTable<String>();
        table.insert(insertValue);

        // act
        var hash = insertValue.hashCode() % table.getSize();
        var readValue = table.read(hash);

        // assert
        assertEquals(insertValue, readValue);
    }

    @Test
    void testToString() {
        // arrange
        var table = new HashTable<String>();

        // act
        table.insert("hello");

        // assert
        assertEquals("HashTable{" +
                "table=[null, null, Allocation{value=hello}, null, null, null, null, null, null, null]" +
                '}',
                table.toString());
    }
}