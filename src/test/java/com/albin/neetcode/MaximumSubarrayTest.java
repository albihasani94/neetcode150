package com.albin.neetcode;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class MaximumSubarrayTest {

    @Test
    void neetcodeExamplesAndBoundaries() {
        var solution = new MaximumSubarray();
        assertEquals(8, solution.maxSubArray(new int[]{2, -3, 4, -2, 2, 1, -1, 4}));
        assertEquals(-1, solution.maxSubArray(new int[]{-1}));

    }
}
