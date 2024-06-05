package ch.hslu.sw13.excercise3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KMPSearchTest {
    @Test
    void testInitNext_EISBEIN() {
        // arrange
        var pattern = "EISBEIN";

        // act
        var shiftArray = KMPSearch.initNext(pattern);

        // print
        for (int i = 0; i < shiftArray.length; i++) {
            System.out.print(shiftArray[i] + ", ");
        }
        System.out.println();
    }

    @Test
    void testInitNext_ANANAS() {
        // arrange
        var pattern = "ANANAS";

        // act
        var shiftArray = KMPSearch.initNext(pattern);

        // print
        for (int i = 0; i < shiftArray.length; i++) {
            System.out.print(shiftArray[i] + ", ");
        }
        System.out.println();
    }
}