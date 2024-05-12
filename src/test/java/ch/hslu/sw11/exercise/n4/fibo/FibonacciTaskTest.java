package ch.hslu.sw11.exercise.n4.fibo;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ForkJoinPool;

class FibonacciTaskTest {
    private static final Logger LOGGER = LoggerFactory.getLogger(FibonacciTaskTest.class);

    @ParameterizedTest
    @ValueSource(ints = { 35, 35, 40, 45, 50 })
    void testFiboRecursivePerf(final int n) {
        // act
        long start = System.nanoTime();
        FibonacciRecursive.fiboRecursive(n);
        long duration = System.nanoTime() - start;

        // print
        LOGGER.info("Fibo Resursive (n={}): {} sec", n, toSeconds(duration));
    }

    @ParameterizedTest
    @ValueSource(ints = { 35, 35, 40, 45, 50 })
    void testFiboParallellizedPerf(final int n) {
        // act
        long duration = -1;

        try (final ForkJoinPool pool = new ForkJoinPool()) {
            long start = System.nanoTime();
            pool.invoke(new FibonacciTask(n));
            duration = System.nanoTime() - start;
        }

        // print
        LOGGER.info("Fibo Parallellized (n={}): {} sec", n, toSeconds(duration));
    }

    private static double toSeconds(long nanos) {
        return nanos / 1_000_000_000d;
    }
}