package com.albin.neetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindMinimumInRotatedSortedArrayTest {

    @Test
    void neetcodeExamplesAndBoundaries() {
        var solution = new FindMinimumInRotatedSortedArray();
        assertEquals(1, solution.findMin(new int[]{3, 4, 5, 6, 1, 2}));
        assertEquals(0, solution.findMin(new int[]{4, 5, 0, 1, 2, 3}));
        assertEquals(4, solution.findMin(new int[]{4, 5, 6, 7}));

    }
}
