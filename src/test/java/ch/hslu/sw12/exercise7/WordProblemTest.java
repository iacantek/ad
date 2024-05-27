package ch.hslu.sw12.exercise7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WordProblemTest {
    @Test
    void testIsWordLanguageTrue() {
        // arrange
        String word = "0101110";

        // act
        boolean isWord = WordProblem.isWordLanguage(word);

        // assert
        assertTrue(isWord);
    }

    @Test
    void testIsWordLanguageFalse_OneAtEnd() {
        // arrange
        String word = "0101111";

        // act
        boolean isWord = WordProblem.isWordLanguage(word);

        // assert
        assertFalse(isWord);
    }

    @Test
    void testIsWordLanguageFalse_OneAtBeginning() {
        // arrange
        String word = "1101110";

        // act
        boolean isWord = WordProblem.isWordLanguage(word);

        // assert
        assertFalse(isWord);
    }

    @Test
    void testIsWordLanguageFalse_EvenNumberOfOnes() {
        // arrange
        String word = "01011110";

        // act
        boolean isWord = WordProblem.isWordLanguage(word);

        // assert
        assertFalse(isWord);
    }

    @Test
    void testIsWordLanguageFalse_ZerosInGroup() {
        // arrange
        String word = "0101001110";

        // act
        boolean isWord = WordProblem.isWordLanguage(word);

        // assert
        assertFalse(isWord);
    }

    // using regex

    @Test
    void testIsWordLanguageTrue_Regex() {
        // arrange
        String word = "0101110";

        // act
        boolean isWord = WordProblem.isWordLanguageRegex(word);

        // assert
        assertTrue(isWord);
    }

    @Test
    void testIsWordLanguageFalse_OneAtEnd_Regex() {
        // arrange
        String word = "0101111";

        // act
        boolean isWord = WordProblem.isWordLanguageRegex(word);

        // assert
        assertFalse(isWord);
    }

    @Test
    void testIsWordLanguageFalse_OneAtBeginning_Regex() {
        // arrange
        String word = "1101110";

        // act
        boolean isWord = WordProblem.isWordLanguageRegex(word);

        // assert
        assertFalse(isWord);
    }

    @Test
    void testIsWordLanguageFalse_EvenNumberOfOnes_Regex() {
        // arrange
        String word = "01011110";

        // act
        boolean isWord = WordProblem.isWordLanguageRegex(word);

        // assert
        assertFalse(isWord);
    }

    @Test
    void testIsWordLanguageFalse_ZerosInGroup_Regex() {
        // arrange
        String word = "0101001110";

        // act
        boolean isWord = WordProblem.isWordLanguageRegex(word);

        // assert
        assertFalse(isWord);
    }
}