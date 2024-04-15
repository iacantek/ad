/*
 * Copyright 2024 Hochschule Luzern - Informatik.
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
package ch.hslu.sw06.exercise.n2.latch;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.util.concurrent.CountDownLatch;

/**
 * Eine Rennbahn für das Pferderennen.
 */
public final class Turf {

    private static final Logger LOG = LoggerFactory.getLogger(Turf.class);
    private static final int HORSES = 20;

    /**
     * Main-Demo.
     * @param args not used.
     */
    public static void main(final String[] args) throws InterruptedException {
//        final Synch starterBox = new Latch();
//        final Thread[] threads = new Thread[HORSES];
//        for (int i = 0; i < HORSES; i++) {
//            threads[i] = Thread.startVirtualThread(new RaceHorse(starterBox, "Rennpferd " + (i + 1)));
//        }
//        Thread.sleep(500); // needed due to error in java implementation of virtual threads
//        LOG.info("Start...");
//        starterBox.release();
//
//        // wait until all horses have finished the race
//        for (var thread : threads) {
//            thread.join();
//        }

        final CountDownLatch readyForStart = new CountDownLatch(HORSES);
        final CountDownLatch finishedRace = new CountDownLatch(HORSES);
        final Synch starterBox = new Latch();
        for (int i = 0; i < HORSES; i++) {
            Thread.startVirtualThread(new RaceHorse(readyForStart, finishedRace, starterBox, "Rennpferd " + (i + 1)));
        }

        readyForStart.await();

        LOG.info("Start...");
        starterBox.release();

        // wait until all horses have finished the race
        finishedRace.await();
    }
}
