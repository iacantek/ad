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
package ch.hslu.sw05.exercise.n1.balls;

import java.util.Random;

/**
 * Demonstration von Bällen.
 */
public class DemoBalls {
    private static final int BALLS_COUNT = 30;
    private static final int BALL_SIZE_MIN = 10;
    private static final int BALL_SIZE_MAX = 40;
    private static final int FALL_SPEED_MIN = 1;
    private static final int FALL_SPEED_MAX = 5;
    private static final String[] COLORS = {"red", "black", "blue", "yellow", "green", "magenta"};

    /**
     * Main-Demo.
     *
     * @param args not used.
     */
    public static void main(final String[] args) {
        var canvas = Canvas.getCanvas();

        for (var i = 0; i < BALLS_COUNT; i++) {
            final int size = new Random().nextInt(BALL_SIZE_MAX - BALL_SIZE_MIN) + BALL_SIZE_MIN;
            final int yPos = canvas.getWidth() / BALLS_COUNT * (i+1);
            final int colorIndex = new Random().nextInt(COLORS.length);
            final int speed = new Random().nextInt(FALL_SPEED_MAX - FALL_SPEED_MIN) + FALL_SPEED_MIN;
            var ball = new Ball(size, yPos, 0, COLORS[colorIndex], speed);

            Thread.startVirtualThread(ball);
        }
    }
}
