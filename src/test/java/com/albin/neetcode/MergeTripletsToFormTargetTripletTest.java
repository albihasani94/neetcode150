package com.albin.neetcode;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class MergeTripletsToFormTargetTripletTest {

    @Test
    void neetcodeExamplesAndBoundaries() {
        var solution = new MergeTripletsToFormTargetTriplet();
        assertTrue(solution.mergeTriplets(new int[][]{{1, 2, 3}, {7, 1, 1}}, new int[]{7, 2, 3}));
        assertFalse(solution.mergeTriplets(
            new int[][]{{2, 5, 6}, {1, 4, 4}, {5, 7, 5}}, new int[]{5, 4, 6}));

    }
}
