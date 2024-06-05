/*
 * Copyright 2024 Roland Gisler, HSLU Informatik, Switzerland
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ch.hslu.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

 import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Demo-Applikation für {@link ch.hslu.demo.Point}-Klasse.
 */
public final class DemoApp {

    private static final Logger LOGGER = LoggerFactory.getLogger(DemoApp.class);

    /** X-Wert. Beispiel. */
    private static final int COR_X = 2;

    /** Y-Wert. Beispiel. */
    private static final int COR_Y = -1;

    /**
     * Privater Konstruktor.
     */
    private DemoApp() {
    }

    /**
     * Main-Methode.
     * @param args Startargumente.
     */
    public static void main(final String[] args) {
        final Point point = new Point(COR_X, COR_Y);
        final int quadrant = point.getQuadrant();
        LOGGER.info("{} befindet sich in Quadrant: {}", point, quadrant);

        LOGGER.info(Arrays.stream(initNext("ANANAS"))
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(", ")));
    }

    /**
     * Erzeugt für das Pattern einen Musterautomaten.
     * @param p Pattern, nach dem später gesucht werden soll.
     * @return Musterautomat in Form eines int-Arrays.
     */
    private static int[] initNext(final String p) {
        final int m = p.length();
        final int[] next = new int[m];
        int i = 0;
        int j = -1;
        next[0] = -1;
// special value! (-1 = no reference to a following state)
        do {
            if ((j == -1) || (p.charAt(i) == p.charAt(j))) {
// (j == -1) must be first operand!
                i++;
                j++;
                next[i] = j;
            } else {
                j = next[j];
            }
        } while (i < (m - 1));
        return next;
    }
}
