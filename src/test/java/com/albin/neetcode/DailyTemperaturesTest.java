package com.albin.neetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DailyTemperaturesTest {

    @Test
    void neetcodeExamplesAndBoundaries() {
        var solution = new DailyTemperatures();
        assertArrayEquals(new int[]{1, 4, 1, 2, 1, 0, 0},
            solution.dailyTemperatures(new int[]{30, 38, 30, 36, 35, 40, 28}));
        assertArrayEquals(new int[]{0, 0, 0}, solution.dailyTemperatures(new int[]{22, 21, 20}));

    }
}
