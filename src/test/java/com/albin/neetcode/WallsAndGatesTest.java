package com.albin.neetcode;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class WallsAndGatesTest {

    @Test
    void neetcodeExamplesAndBoundaries() {
        var solution = new WallsAndGates();
        int inf = Integer.MAX_VALUE;
        int[][] grid = {
            {inf, -1, 0, inf}, {inf, inf, inf, -1},
            {inf, -1, inf, -1}, {0, -1, inf, inf}
        };
        solution.islandsAndTreasure(grid);
        TestSupport.assertMatrixEquals(new int[][]{
            {3, -1, 0, 1}, {2, 2, 1, -1}, {1, -1, 2, -1}, {0, -1, 3, 4}
        }, grid);
        int[][] small = {{0, -1}, {inf, inf}};
        solution.islandsAndTreasure(small);
        TestSupport.assertMatrixEquals(new int[][]{{0, -1}, {1, 2}}, small);

    }
}
