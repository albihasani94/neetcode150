package com.albin.neetcode;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class InsertIntervalTest {

    @Test
    void neetcodeExamplesAndBoundaries() {
        var solution = new InsertInterval();
        TestSupport.assertMatrixEquals(new int[][]{{1, 6}},
            solution.insert(new int[][]{{1, 3}, {4, 6}}, new int[]{2, 5}));
        TestSupport.assertMatrixEquals(new int[][]{{1, 2}, {3, 5}, {6, 7}, {9, 10}},
            solution.insert(new int[][]{{1, 2}, {3, 5}, {9, 10}}, new int[]{6, 7}));

    }
}
