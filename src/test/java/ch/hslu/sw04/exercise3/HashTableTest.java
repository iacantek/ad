package ch.hslu.sw04.exercise3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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
    void testInsertSameHash() {
        // arrange
        var table = new HashTable<Character>();

        // act
        var successA = table.insert('a'); // index: 7 (hash code % 10)
        var successK = table.insert('k'); // index: 7 (hash code % 10)

        // assert
        assertTrue(successA);
        assertTrue(successK);
        assertEquals('a', table.read(7));
        assertEquals('k', table.read(8));
    }

    @Test
    void testInsertAlreadyFull() {
        // arrange
        var table = new HashTable<Character>();
        table.insert('d'); // index: 0 (hash code % 10)
        table.insert('e'); // index: 1 (hash code % 10)
        table.insert('f'); // index: 2 (hash code % 10)
        table.insert('g'); // index: 3 (hash code % 10)
        table.insert('h'); // index: 4 (hash code % 10)
        table.insert('i'); // index: 5 (hash code % 10)
        table.insert('j'); // index: 6 (hash code % 10)
        table.insert('a'); // index: 7 (hash code % 10)
        table.insert('b'); // index: 8 (hash code % 10)
        table.insert('c'); // index: 9 (hash code % 10)

        // act
        var success = table.insert('k'); // index: 7 (hash code % 10)

        // assert
        assertFalse(success);
    }

    @Test
    void testInsertAlmostFull() {
        // arrange
        var table = new HashTable<Character>();
        table.insert('d'); // index: 0 (hash code % 10)
        table.insert('e'); // index: 1 (hash code % 10)
        table.insert('f'); // index: 2 (hash code % 10)
        table.insert('g'); // index: 3 (hash code % 10)
        table.insert('h'); // index: 4 (hash code % 10)
        table.insert('i'); // index: 5 (hash code % 10)
        table.insert('j'); // index: 6 (hash code % 10)
        table.insert('a'); // index: 7 (hash code % 10)
        table.insert('k'); // index: 7 => 8 (hash code % 10)

        // act
        var successB = table.insert('b'); // index: 8 => 9 (hash code % 10)
        var successC = table.insert('c'); // index: 9 (hash code % 10)

        // assert
        assertTrue(successB);
        assertFalse(successC);
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
    void testSearch() {
        // arrange
        var table = new HashTable<Character>();
        table.insert('k'); // index: 7 (hash code % 10)

        // act
        var index = table.search('k');

        // assert
        assertEquals(7, index);
    }

    @Test
    void testSearchProbe() {
        // arrange
        var table = new HashTable<Character>();
        table.insert('a'); // index: 7 (hash code % 10)
        table.insert('k'); // index: 7 => 8 (hash code % 10)

        // act
        var index = table.search('k');

        // assert
        assertEquals(8, index);
    }

    @Test
    void testSearchProbeWithGravestone() {
        // arrange
        var table = new HashTable<Character>();
        table.insert('a'); // index: 7 (hash code % 10)
        table.insert('b'); // index: 8 (hash code % 10)
        table.insert('c'); // index: 9 (hash code % 10)
        table.insert('k'); // index: 7 => 0 (hash code % 10)
        table.remove('b');
        table.remove('c');

        // act
        var index = table.search('k');

        // assert
        assertEquals(0, index);
    }

    @Test
    void testSearchDoesNotExist() {
        // arrange
        var table = new HashTable<Character>();

        // act
        var index = table.search('a');

        // assert
        assertNull(index);
    }

    @Test
    void testRemove() {
        // arrange
        var table = new HashTable<Character>();
        table.insert('k'); // index: 7 (hash code % 10)

        // act
        var sizeBefore = table.allocatedSize();
        var success = table.remove('k');

        // assert
        assertTrue(success);
        assertEquals(sizeBefore-1, table.allocatedSize());
    }

    @Test
    void testRemoveProbe() {
        // arrange
        var table = new HashTable<Character>();
        table.insert('a'); // index: 7 (hash code % 10)
        table.insert('k'); // index: 7 => 8 (hash code % 10)

        // act
        var sizeBefore = table.allocatedSize();
        var success = table.remove('k');

        // assert
        assertTrue(success);
        assertEquals(sizeBefore-1, table.allocatedSize());
    }

    @Test
    void testRemoveProbeWithGravestone() {
        // arrange
        var table = new HashTable<Character>();
        table.insert('a'); // index: 7 (hash code % 10)
        table.insert('b'); // index: 8 (hash code % 10)
        table.insert('c'); // index: 9 (hash code % 10)
        table.insert('k'); // index: 7 => 0 (hash code % 10)
        table.remove('b');
        table.remove('c');

        // act
        var sizeBefore = table.allocatedSize();
        var success = table.remove('k');

        // assert
        assertTrue(success);
        assertEquals(sizeBefore-1, table.allocatedSize());
    }

    @Test
    void testRemoveDoesNotExist() {
        // arrange
        var table = new HashTable<Character>();

        // act
        var sizeBefore = table.allocatedSize();
        var success = table.remove('a');

        // assert
        assertFalse(success);
        assertEquals(sizeBefore, table.allocatedSize());
    }

    @Test
    void testAllocatedSize() {
        // arrange
        var table = new HashTable<Character>();

        // act
        table.insert('d'); // index: 0 (hash code % 10)
        table.insert('e'); // index: 1 (hash code % 10)
        table.insert('f'); // index: 2 (hash code % 10)

        // assert
        assertEquals(3, table.allocatedSize());
    }

    @Test
    void testSize() {
        // arrange
        var table = new HashTable<Character>();

        // assert
        assertEquals(10, table.size());
    }

    @Test
    void testToString() {
        // arrange
        var table = new ch.hslu.sw04.exercise1.HashTable<Character>();

        // act
        table.insert('a');

        // assert
        assertEquals("HashTable{" +
                        "table=[null, null, null, null, null, null, null, Allocation{value=a}, null, null]" +
                        '}',
                table.toString());
    }
}