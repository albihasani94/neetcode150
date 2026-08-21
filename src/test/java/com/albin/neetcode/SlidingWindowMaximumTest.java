package com.albin.neetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SlidingWindowMaximumTest {

    @Test
    void neetcodeExamplesAndBoundaries() {
        var solution = new SlidingWindowMaximum();
        assertArrayEquals(new int[]{2, 2, 4, 4, 6},
            solution.maxSlidingWindow(new int[]{1, 2, 1, 0, 4, 2, 6}, 3));
        assertArrayEquals(new int[]{-2}, solution.maxSlidingWindow(new int[]{-2}, 1));

    }
}
