package com.albin.neetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MedianOfTwoSortedArraysTest {

    @Test
    void neetcodeExamplesAndBoundaries() {
        var solution = new MedianOfTwoSortedArrays();
        assertEquals(2.0, solution.findMedianSortedArrays(new int[]{1, 2}, new int[]{3}));
        assertEquals(2.5, solution.findMedianSortedArrays(new int[]{1, 3}, new int[]{2, 4}));
        assertEquals(1.0, solution.findMedianSortedArrays(new int[]{}, new int[]{1}));

    }
}
