package com.albin.neetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LargestRectangleInHistogramTest {

    @Test
    void neetcodeExamplesAndBoundaries() {
        var solution = new LargestRectangleInHistogram();
        assertEquals(8, solution.largestRectangleArea(new int[]{7, 1, 7, 2, 2, 4}));
        assertEquals(7, solution.largestRectangleArea(new int[]{1, 3, 7}));
        assertEquals(5, solution.largestRectangleArea(new int[]{5}));

    }
}
