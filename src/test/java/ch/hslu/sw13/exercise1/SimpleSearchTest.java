package ch.hslu.sw13.exercise1;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class SimpleSearchTest {
    private final static int TEXT_LENGTH = 100_000;

    private static String text;

    @BeforeAll
    static void setUp() {
        var textBuilder = new StringBuilder(TEXT_LENGTH);
        for (int i = 0; i < TEXT_LENGTH; i++) {
            textBuilder.append("a");
        }
        text = textBuilder.toString();
    }

    @Test
    void testSimpleSearch_BestCase() {
        // arrange
        var pattern = "aaaaaaaaaa";

        // act
        SimpleSearch.simpleSearch(text, pattern);
    }

    @Test
    void testSimpleSearch_AverageCase() {
        // arrange
        var pattern = "bbbbbbbbbb";

        // act
        SimpleSearch.simpleSearch(text, pattern);
    }

    @Test
    void testSimpleSearch_WorstCase() {
        // arrange
        var pattern = "aaaaaaaaab";

        // act
        SimpleSearch.simpleSearch(text, pattern);
    }
}