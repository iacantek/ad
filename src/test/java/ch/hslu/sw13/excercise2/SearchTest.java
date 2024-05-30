package ch.hslu.sw13.excercise2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SearchTest {

    @Test
    void testStateSearchFound_Index0() {
        // arrange
        var text = "ANANASBCDEFG";

        // act
        var index = Search.stateSearch(text);

        // assert
        assertEquals(0, index);
    }

    @Test
    void testStateSearchFound_Index4() {
        // arrange
        var text = "ABCDANANASEFG";

        // act
        var index = Search.stateSearch(text);

        // assert
        assertEquals(4, index);
    }

    @Test
    void testStateSearchNotFoundNull() {
        // arrange
        String text = null;

        // act
        var index = Search.stateSearch(text);

        // assert
        assertEquals(-1, index);
    }

    @Test
    void testStateSearchNotFoundEmpty() {
        // arrange
        var text = "";

        // act
        var index = Search.stateSearch(text);

        // assert
        assertEquals(-1, index);
    }

    @Test
    void testStateSearchNotFoundAtEnd() {
        // arrange
        var text = "ABCDEFGANANA";

        // act
        var index = Search.stateSearch(text);

        // assert
        assertEquals(-1, index);
    }

    @Test
    void testStateSearchNotFoundAtBeginning() {
        // arrange
        var text = "ANANABCDEFG";

        // act
        var index = Search.stateSearch(text);

        // assert
        assertEquals(-1, index);
    }
}