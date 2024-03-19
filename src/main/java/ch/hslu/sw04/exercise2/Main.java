package ch.hslu.sw04.exercise2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Stack;

public final class Main {
    private static final int RUNS = 1_000;
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(final String[] args) {
        var data1 = ArrayFactory.createArray(100_000);
        var data2 = ArrayFactory.createArray(1_000_000);

        // warm-up (100'000 objects, 1'000 runs)
        runStack(RUNS, data1, true); // java.util.Stack
        runOwnStack(RUNS, data1, true); // own Stack
        runDeque(RUNS, data1, true); // java.util.Dequeue

        // run 1 (100'000 objects, 1'000 runs)
        runStack(RUNS, data1); // java.util.Stack
        runOwnStack(RUNS, data1); // own Stack
        runDeque(RUNS, data1); // java.util.Dequeue

        // run 2 (1'000'000 objects, 1'000 runs)
        runStack(RUNS, data2); // java.util.Stack
        runOwnStack(RUNS, data2); // own Stack
        runDeque(RUNS, data2); // java.util.Dequeue
    }

    private static void runStack(final int runs, final Allocation[] data) {
        runStack(runs, data, false);
    }
    private static void runStack(final int runs, final Allocation[] data, boolean isWarmUp) {
        var runTimes = new long[runs];

        for (var i = 0; i < runs; i++) {
            var stack = new Stack<Allocation>();
            long startStack = System.nanoTime();
            for (var j = 0; j < data.length; j++) {
                stack.push(data[j]);
            }
            long endStack = System.nanoTime();

            runTimes[i] = endStack - startStack;
        }

        var average = (long) Arrays.stream(runTimes).asDoubleStream().average().orElse(0);

        LOGGER.info("Duration Stack: (" + runs + " runs) " + formatInterval(average) + (isWarmUp ? " (warm-up)" : ""));
    }

    private static void runOwnStack(final int runs, final Allocation[] data) {
        runOwnStack(runs, data, false);
    }
    private static void runOwnStack(final int runs, final Allocation[] data, boolean isWarmUp) {
        var runTimes = new long[runs];

        for (var i = 0; i < runs; i++) {
            var ownStack = new ArrayStack<Allocation>(data.length);
            long startStack = System.nanoTime();
            for (var j = 0; j < data.length; j++) {
                ownStack.push(data[j]);
            }
            long endStack = System.nanoTime();

            runTimes[i] = endStack - startStack;
        }

        var average = (long) Arrays.stream(runTimes).asDoubleStream().average().orElse(0);

        LOGGER.info("Duration Own Stack: (" + runs + " runs) " + formatInterval(average) + (isWarmUp ? " (warm-up)" : ""));
    }

    private static void runDeque(final int runs, final Allocation[] data) {
        runStack(runs, data, false);
    }
    private static void runDeque(final int runs, final Allocation[] data, boolean isWarmUp) {
        var runTimes = new long[runs];

        for (var i = 0; i < runs; i++) {
            var deque = new ArrayDeque<Allocation>(data.length);
            long startStack = System.nanoTime();
            for (var j = 0; j < data.length; j++) {
                deque.push(data[j]);
            }
            long endStack = System.nanoTime();

            runTimes[i] = endStack - startStack;
        }

        var average = (long) Arrays.stream(runTimes).asDoubleStream().average().orElse(0);

        LOGGER.info("Duration Deque: (" + runs + " runs) " + formatInterval(average) + (isWarmUp ? " (warm-up)" : ""));
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
