package ch.hslu.sw04.exercise2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Stack;

public final class Main {
    private static final int SIZE = 10_000;
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(final String[] args) {
        var data = ArrayFactory.createArray(SIZE);

        // warm-up (100'000)
        final int runsWarmup = 100;
        runStack(runsWarmup, data, true); // java.util.Stack
        runOwnStack(runsWarmup, data, true); // own Stack
        runDequeue(runsWarmup, data, true); // java.util.Dequeue

        // run 1 (100'000)
        final int run1 = 1_000;
        runStack(run1, data); // java.util.Stack
        runOwnStack(run1, data); // own Stack
        runDequeue(run1, data); // java.util.Dequeue

        // run 2 (1'000'000)
        final int run2 = 10_000;
        runStack(run2, data); // java.util.Stack
        runOwnStack(run2, data); // own Stack
        runDequeue(run2, data); // java.util.Dequeue
    }

    private static void runStack(final int runs, final Allocation[] data) {
        runStack(runs, data, false);
    }
    private static void runStack(final int runs, final Allocation[] data, boolean isWarmUp) {
        var runTimes = new long[runs];

        for (var i = 0; i < runs; i++) {
            var stack = new Stack<Allocation>();
            long startStack = System.nanoTime();
            for (var item : data) {
                stack.push(item);
            }
            long endStack = System.nanoTime();

            runTimes[i] = endStack - startStack;
        }

        var average = (long) Arrays.stream(runTimes).asDoubleStream().average().orElse(0);

        if (!isWarmUp) {
            LOGGER.info("Duration Stack: " + formatInterval(average));
        }
    }

    private static void runOwnStack(final int runs, final Allocation[] data) {
        runOwnStack(runs, data, false);
    }
    private static void runOwnStack(final int runs, final Allocation[] data, boolean isWarmUp) {
        var runTimes = new long[runs];

        for (var i = 0; i < runs; i++) {
            var ownStack = new ArrayStack<Allocation>(SIZE);
            long startStack = System.nanoTime();
            for (var item : data) {
                ownStack.push(item);
            }
            long endStack = System.nanoTime();

            runTimes[i] = endStack - startStack;
        }

        var average = (long) Arrays.stream(runTimes).asDoubleStream().average().orElse(0);

        if (!isWarmUp) {
            LOGGER.info("Duration Own Stack: " + formatInterval(average));
        }
    }

    private static void runDequeue(final int runs, final Allocation[] data) {
        runStack(runs, data, false);
    }
    private static void runDequeue(final int runs, final Allocation[] data, boolean isWarmUp) {
        var runTimes = new long[runs];

        for (var i = 0; i < runs; i++) {
            var deque = new ArrayDeque<Allocation>(SIZE);
            long startStack = System.nanoTime();
            for (var item : data) {
                deque.push(item);
            }
            long endStack = System.nanoTime();

            runTimes[i] = endStack - startStack;
        }

        var average = (long) Arrays.stream(runTimes).asDoubleStream().average().orElse(0);

        if (!isWarmUp) {
            LOGGER.info("Duration Deque: " + formatInterval(average));
        }
    }

    private static String formatInterval(final long nanos)
    {
        var duration = Duration.ofNanos(nanos);
        var formattedElapsedTime = String.format("%02d Second %d Millisecond %d Nanosecond",
                duration.toSecondsPart(),
                duration.toMillisPart(), duration.toNanosPart() % 1000000L);
        return formattedElapsedTime;
    }
}
