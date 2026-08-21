package com.albin.neetcode;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class MergeIntervalsTest {

    @Test
    void neetcodeExamplesAndBoundaries() {
        var solution = new MergeIntervals();
        TestSupport.assertMatrixEquals(new int[][]{{1, 5}, {6, 7}},
            solution.merge(new int[][]{{1, 3}, {1, 5}, {6, 7}}));
        TestSupport.assertMatrixEquals(new int[][]{{1, 3}}, solution.merge(new int[][]{{1, 2}, {2, 3}}));

    }
}
