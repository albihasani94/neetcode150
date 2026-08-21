package com.albin.neetcode;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class PacificAtlanticWaterFlowTest {

    @Test
    void neetcodeExamplesAndBoundaries() {
        var solution = new PacificAtlanticWaterFlow();
        TestSupport.assertNestedIntRowsIgnoringOrder(
            new int[][]{{0, 2}, {0, 4}, {1, 0}, {1, 1}, {1, 2}, {1, 3}, {1, 4}, {2, 0}},
            solution.pacificAtlantic(new int[][]{{4, 2, 7, 3, 4}, {7, 4, 6, 4, 7}, {6, 3, 5, 3, 6}}));
        TestSupport.assertNestedIntRowsIgnoringOrder(new int[][]{{0, 0}, {1, 0}},
            solution.pacificAtlantic(new int[][]{{1}, {1}}));

    }
}
