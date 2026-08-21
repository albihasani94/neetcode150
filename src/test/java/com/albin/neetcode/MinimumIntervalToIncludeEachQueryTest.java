package com.albin.neetcode;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class MinimumIntervalToIncludeEachQueryTest {

    @Test
    void neetcodeExamplesAndBoundaries() {
        var solution = new MinimumIntervalToIncludeEachQuery();
        assertArrayEquals(new int[]{2, 2, 3, 5, 1, -1}, solution.minInterval(
            new int[][]{{1, 3}, {2, 3}, {3, 7}, {6, 6}}, new int[]{2, 3, 1, 7, 6, 8}));

    }
}
