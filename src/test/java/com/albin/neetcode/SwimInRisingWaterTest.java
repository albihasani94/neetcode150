package com.albin.neetcode;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class SwimInRisingWaterTest {

    @Test
    void neetcodeExamplesAndBoundaries() {
        var solution = new SwimInRisingWater();
        assertEquals(3, solution.swimInWater(new int[][]{{0, 1}, {2, 3}}));
        assertEquals(8, solution.swimInWater(new int[][]{
            {0, 1, 2, 10}, {9, 14, 4, 13}, {12, 3, 8, 15}, {11, 5, 7, 6}
        }));

    }
}
