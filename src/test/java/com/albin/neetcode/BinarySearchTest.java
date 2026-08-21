package com.albin.neetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTest {

    @Test
    void neetcodeExamplesAndBoundaries() {
        var solution = new BinarySearch();
        assertEquals(3, solution.search(new int[]{-1, 0, 2, 4, 6, 8}, 4));
        assertEquals(-1, solution.search(new int[]{-1, 0, 2, 4, 6, 8}, 3));
        assertEquals(0, solution.search(new int[]{7}, 7));

    }
}
