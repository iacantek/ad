package ch.hslu.sw08;

import java.util.concurrent.*;

public final class Main {
    public static void main(final String[] args) throws InterruptedException, ExecutionException {
        BlockingQueue<String> blockingQueue = new LinkedBlockingQueue<>();

        var result = blockingQueue.offer("Hello", 1, TimeUnit.MICROSECONDS);
        var s = blockingQueue.poll(1, TimeUnit.MICROSECONDS);

        try (final ExecutorService executorService = Executors.newCachedThreadPool()) {
            for (int i = 0; i < 10; i++) {
                int finalI = i;
                executorService.execute(() -> {
                    System.out.print(finalI);
                });
            }
        }

        final ExecutorService executorService = Executors.newCachedThreadPool();

        final Callable<Integer> task = () -> {
            return 0;
        };

        final Future<Integer> future = executorService.submit(task);
        var sum = future.get();
    }
}
