/*
 * Copyright 2024 Hochschule Luzern Informatik.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ch.hslu.sw11.exercise.n4.fibo;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.RecursiveTask;

/**
 * Codevorlage für ein klassisches Beispiel zur Berechnung von Fibonacci Zahlen.
 */
@SuppressWarnings("serial")
public final class FibonacciTask extends RecursiveTask<Long> {

    private static final Map<Integer, Long> results = new ConcurrentHashMap<>();
    private final int n;

    /**
     * Erzeugt einen Fibonacci Task.
     *
     * @param n für die Fibonacci Berechnung.
     */
    public FibonacciTask(final int n) {
        this.n = n;
    }

    @Override
    protected Long compute() {
        if (n <= 1) {
            return (long) n;
        }

        if (results.containsKey(n)) {
            return results.get(n);
        }

        var fibo1 = new FibonacciTask(n - 1);
        fibo1.fork();
        var fibo2 = new FibonacciTask(n - 2);

        var result = fibo1.join() + fibo2.invoke();
        results.put(n, result);

        return result;
    }
}
