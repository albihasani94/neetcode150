package com.albin.neetcode;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class MinCostClimbingStairsTest {

    @Test
    void neetcodeExamplesAndBoundaries() {
        var solution = new MinCostClimbingStairs();
        assertEquals(2, solution.minCostClimbingStairs(new int[]{1, 2, 3}));
        assertEquals(4, solution.minCostClimbingStairs(new int[]{1, 2, 1, 2, 1, 1, 1}));

    }
}
