package com.albin.neetcode;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class MaximumProductSubarrayTest {

    @Test
    void neetcodeExamplesAndBoundaries() {
        var solution = new MaximumProductSubarray();
        assertEquals(8, solution.maxProduct(new int[]{2, 4, -3, 5}));
        assertEquals(0, solution.maxProduct(new int[]{-3, 0, -2}));
        assertEquals(-2, solution.maxProduct(new int[]{-2}));

    }
}
