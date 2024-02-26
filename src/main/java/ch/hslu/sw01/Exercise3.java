package ch.hslu.sw01;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Exercise3 {
    private static final Logger LOGGER = LoggerFactory.getLogger(Exercise3.class);

    public static void main(final String[] args) {
        // 3. a)
        LOGGER.info("log n | ld n | n | n * log n | n^2 | n^3 | 2^n | 3^n | n!");

        int[] numbers = {1, 2, 5, 10, 20, 50, 100};

        for (var n : numbers) {
            var log = Math.log10(n);
            var ld = Math.log(n) / Math.log(2);
            var nlogn = n * Math.log10(n);
            var exp2 = Math.pow(n, 2);
            var exp3 = Math.pow(n, 3);
            var base2 = Math.pow(2, n);
            var base3 = Math.pow(3, n);
            var factorial = factorial(n);

            LOGGER.info(padRight(String.valueOf(log)) + " | " +
                    padRight(String.valueOf(ld)) + " | " +
                        padRight(String.valueOf(n)) + " | " +
                            padRight(String.valueOf(nlogn)) + " | " +
                                    padRight(String.valueOf(exp2)) + " | " +
                                            padRight(String.valueOf(exp3)) + " | " +
                                                    padRight(String.valueOf(base2)) + " | " +
                                                            padRight(String.valueOf(base3)) + " | " +
                                                                    padRight(String.valueOf(factorial)));
        }

        // 3. b)


    }

    private static long factorial(int n) {
        long fact = 1;
        for (int i = 2; i <= n; i++) {
            fact = fact * i;
        }
        return fact;
    }

    private static String padRight(String s) {
        return String.format("%-" + 21 + "s", s);
    }
}
