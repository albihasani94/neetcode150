package com.albin.neetcode;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class LongestIncreasingPathInAMatrixTest {

    @Test
    void neetcodeExamplesAndBoundaries() {
        var solution = new LongestIncreasingPathInAMatrix();
        assertEquals(4, solution.longestIncreasingPath(new int[][]{{5, 5, 3}, {2, 3, 6}, {1, 1, 1}}));
        assertEquals(7, solution.longestIncreasingPath(new int[][]{{1, 2, 3}, {2, 1, 4}, {7, 6, 5}}));
        assertEquals(1, solution.longestIncreasingPath(new int[][]{{9}}));

    }
}
