package ch.hslu.sw01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Exercise2 {
    private static final Logger LOGGER = LoggerFactory.getLogger(Exercise2.class);
    private static int task1Counter = 0;
    private static int task2Counter = 0;
    private static int task3Counter = 0;

    public static void main(final String[] args) throws InterruptedException {
        var timeStamp1 = LocalDateTime.now();
        task(1);
        var difference1 = timeStamp1.until(LocalDateTime.now(), ChronoUnit.SECONDS);

        var timeStamp2 = LocalDateTime.now();
        task(10);
        var difference2 = timeStamp2.until(LocalDateTime.now(), ChronoUnit.SECONDS);

        var timeStamp3 = LocalDateTime.now();
        task(100);
        var difference3 = timeStamp3.until(LocalDateTime.now(), ChronoUnit.SECONDS);

        LOGGER.info("Duration (n=1): " + difference1 + " seconds");
        LOGGER.info("Duration (n=10): " + difference2 + " seconds");
        LOGGER.info("Duration (n=100): " + difference3 + " seconds");
    }

    public static void task(final int n) throws InterruptedException {
        task1(); task1(); task1(); task1(); // T ~ 4
        for (int i = 0; i < n; i++) { // äussere Schleife: n-mal
            task2(); task2(); task2(); // T ~ n · 3
            for (int j = 0; j < n; j++) { // innerer Schleife: n-mal
                task3(); task3(); // T ~ n · n· 2
            }
        }

        LOGGER.info("Task 1: " + task1Counter);
        LOGGER.info("Task 2: " + task2Counter);
        LOGGER.info("Task 3: " + task3Counter);
    }

    private static void task1() throws InterruptedException {
        task1Counter++;
        Thread.sleep(5);
    }

    private static void task2() throws InterruptedException {
        task2Counter++;
        Thread.sleep(5);
    }

    private static void task3() throws InterruptedException {
        task3Counter++;
        Thread.sleep(5);
    }
}
