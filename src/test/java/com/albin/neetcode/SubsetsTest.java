package com.albin.neetcode;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class SubsetsTest {

    @Test
    void neetcodeExamplesAndBoundaries() {
        var solution = new Subsets();
        TestSupport.assertNestedIntsIgnoringOrder(
            new int[][]{{}, {1}, {2}, {1, 2}, {3}, {1, 3}, {2, 3}, {1, 2, 3}},
            solution.subsets(new int[]{1, 2, 3}));
        TestSupport.assertNestedIntsIgnoringOrder(new int[][]{{}, {7}}, solution.subsets(new int[]{7}));

    }
}
