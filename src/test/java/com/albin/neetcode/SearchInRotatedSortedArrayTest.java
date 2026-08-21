package com.albin.neetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SearchInRotatedSortedArrayTest {

    @Test
    void neetcodeExamplesAndBoundaries() {
        var solution = new SearchInRotatedSortedArray();
        assertEquals(4, solution.search(new int[]{3, 4, 5, 6, 1, 2}, 1));
        assertEquals(-1, solution.search(new int[]{3, 5, 6, 0, 1, 2}, 4));

    }
}
