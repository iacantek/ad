package ch.hslu.sw10.exercise2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RecursiveCallStackOverflow {
    private static final Logger LOGGER = LoggerFactory.getLogger(RecursiveCallStackOverflow.class);
    private static int depth = 0;

    public static void main(String[] args) {
        try {
            recursiveStackOverflow();
        } catch (StackOverflowError e) {
            LOGGER.info("Maximum depth of the call stack is " + depth);
        }
    }

    private static void recursiveStackOverflow() {
        depth++;
        recursiveStackOverflow();
    }
}
