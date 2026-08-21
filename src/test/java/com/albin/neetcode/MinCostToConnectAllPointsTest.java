package com.albin.neetcode;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class MinCostToConnectAllPointsTest {

    @Test
    void neetcodeExamplesAndBoundaries() {
        var solution = new MinCostToConnectAllPoints();
        assertEquals(10, solution.minCostConnectPoints(
            new int[][]{{0, 0}, {2, 2}, {3, 3}, {2, 4}, {4, 2}}));
        assertEquals(0, solution.minCostConnectPoints(new int[][]{{1, 1}}));

    }
}
