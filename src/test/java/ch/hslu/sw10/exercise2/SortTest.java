package ch.hslu.sw10.exercise2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class SortTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(SortTest.class);

    /**
     * Tests performance of quick sort using a Character array of various sizes.
     * @param length Array size
     */
    @ParameterizedTest
    @ValueSource(ints = { 100_000, 500_000, 1_000_000 })
    void testQuickSortPerformanceCharacters(final int length) {
        // arrange
        var chars = Sort.randomChars(length);

        // act
        double[] durations = sort(chars, 3);

        // output
        printResult(length, durations);
    }

    /**
     * Tests performance of quick sort using an Integer array of various sizes.
     * @param length Array size
     */
    @ParameterizedTest
    @ValueSource(ints = { 10_000_000, 20_000_000, 40_000_000 }) // OutOfMemoryError at 50 Mio.
    void testQuickSortPerformanceIntegers(final int length) {
        // arrange
        var ints = Sort.randomInts(length, 1_000);

        // act
        double[] durations = sort(ints, 3);

        // output
        printResult(length, durations);
    }

    private <T extends Comparable<T>> double[] sort(final T[] array, final int iterations) {
        double[] durations = new double[iterations];
        for (int i = 0; i < iterations; i++) {
            var arr = Arrays.copyOf(array, array.length);

            long start = System.nanoTime();
            Sort.quickSort(arr); // sort array
            long duration = System.nanoTime() - start;

            durations[i] = duration / 1_000_000d;
        }
        return durations;
    }

    private void printResult(final int length, final double[] durations) {
        for (int i = 0; i < durations.length; i++) {
            LOGGER.info("Iteration {} ({} items): {} ms", i+1, length, durations[i]);
        }
    }

    @Test
    void testQuickSortRandomArray() {
        // arrange
        var arr1 = Sort.randomChars(100);
        var arr2 = Arrays.copyOf(arr1, arr1.length);

        // act
        Arrays.sort(arr1);
        Sort.quickSort(arr2);

        // assert
        assertArrayEquals(arr1, arr2);
    }

    @Test
    void testQuickSortStaticArray() {
        // arrange
        var arr1 = new Character[] { 'G', 'D', 'E', 'V', 'A', 'L' };
        var arr2 = Arrays.copyOf(arr1, arr1.length);

        // act
        Arrays.sort(arr1);
        Sort.quickSort(arr2);

        // assert
        assertArrayEquals(arr1, arr2);
    }

    @Test
    void testRandomChars() {
        // arrange
        int length = 10;

        // act
        var arr = Sort.randomChars(length);

        // assert
        assertEquals(length, arr.length);
    }
}