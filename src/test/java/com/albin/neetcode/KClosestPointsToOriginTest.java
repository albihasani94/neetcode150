package com.albin.neetcode;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class KClosestPointsToOriginTest {

    @Test
    void neetcodeExamplesAndBoundaries() {
        var solution = new KClosestPointsToOrigin();
        TestSupport.assertRowsIgnoringOrder(new int[][]{{0, 2}},
            solution.kClosest(new int[][]{{0, 2}, {2, 2}}, 1));
        TestSupport.assertRowsIgnoringOrder(new int[][]{{0, 2}, {2, 0}},
            solution.kClosest(new int[][]{{0, 2}, {2, 0}, {2, 2}}, 2));

    }
}
