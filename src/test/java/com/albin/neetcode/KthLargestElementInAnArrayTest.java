package com.albin.neetcode;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class KthLargestElementInAnArrayTest {

    @Test
    void neetcodeExamplesAndBoundaries() {
        var solution = new KthLargestElementInAnArray();
        assertEquals(4, solution.findKthLargest(new int[]{2, 3, 1, 5, 4}, 2));
        assertEquals(4, solution.findKthLargest(new int[]{2, 3, 1, 1, 5, 5, 4}, 3));

    }
}
