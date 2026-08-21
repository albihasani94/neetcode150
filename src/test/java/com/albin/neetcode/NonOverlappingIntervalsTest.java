package com.albin.neetcode;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class NonOverlappingIntervalsTest {

    @Test
    void neetcodeExamplesAndBoundaries() {
        var solution = new NonOverlappingIntervals();
        assertEquals(1, solution.eraseOverlapIntervals(new int[][]{{1, 2}, {2, 4}, {1, 4}}));
        assertEquals(0, solution.eraseOverlapIntervals(new int[][]{{1, 2}, {2, 4}}));

    }
}
