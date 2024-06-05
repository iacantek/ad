package ch.hslu.sw13.excercise5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SearchTest {
    @Test
    void testQuickSearch_FoundAtBeginning() {
        // arrange
        var string = "aaabaaaaaaaaa";
        var pattern = "aaab";

        // act
        var index = Search.quickSearch(string, pattern);

        // assert
        assertEquals(0, index);
    }

    @Test
    void testQuickSearch_FoundAtIndex3() {
        // arrange
        var string = "aaaaaabaaaaaa";
        var pattern = "aaab";

        // act
        var index = Search.quickSearch(string, pattern);

        // assert
        assertEquals(3, index);
    }

    @Test
    void testQuickSearch_FoundAtEnd() {
        // arrange
        var string = "aaaaaaaaaaaab";
        var pattern = "aaab";

        // act
        var index = Search.quickSearch(string, pattern);

        // assert
        assertEquals(9, index);
    }

    @Test
    void testQuickSearch_NotFound() {
        // arrange
        var string = "aaaaaaaaaaaaa";
        var pattern = "bbbb";

        // act
        var index = Search.quickSearch(string, pattern);

        // assert
        assertEquals(-1, index);
    }
}