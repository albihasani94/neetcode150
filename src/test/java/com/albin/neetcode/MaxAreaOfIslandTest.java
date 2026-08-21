package com.albin.neetcode;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class MaxAreaOfIslandTest {

    @Test
    void neetcodeExamplesAndBoundaries() {
        var solution = new MaxAreaOfIsland();
        int[][] grid = {
            {0, 1, 1, 0, 1}, {1, 0, 1, 0, 1},
            {0, 1, 1, 0, 1}, {0, 1, 0, 0, 1}
        };
        assertEquals(6, solution.maxAreaOfIsland(grid));
        assertEquals(0, solution.maxAreaOfIsland(new int[][]{{0, 0}, {0, 0}}));

    }
}
