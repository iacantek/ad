package ch.hslu.sw01;

import ch.hslu.demo.DemoApp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Exercise1 {
    private static final Logger LOGGER = LoggerFactory.getLogger(Exercise1.class);
    public static void main(final String[] args) {
        LOGGER.info(String.valueOf(ggtIterativ1(16, 68)));
        LOGGER.info(String.valueOf(ggtIterativ2(16, 68)));
        LOGGER.info(String.valueOf(ggtRekursiv(16, 68)));
    }

    private static int ggtIterativ1(int a, int b) {
        while (a != b) {
            if (a > b) {
                a = a - b;
            } else {
                b = b - a;
            }
        }
        return a;
    }

    private static int ggtIterativ2(int a, int b) {
        while ((a != 0) && (b != 0)) {
            if (a > b) {
                a = a % b;
            } else {
                b = b % a;
            }
        }
        return (a + b); // Entweder a oder b ist 0!
    }

    private static int ggtRekursiv(final int a, final int b) {
        if (a > b) {
            return ggtRekursiv(a - b, b);
        } else {
            if (a < b) {
                return ggtRekursiv(a, b - a);
            } else {
                return a;
            }
        }
    }
}
