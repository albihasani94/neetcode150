package com.albin.neetcode;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class SubsetsIITest {

    @Test
    void neetcodeExamplesAndBoundaries() {
        var solution = new SubsetsII();
        TestSupport.assertNestedIntsIgnoringOrder(
            new int[][]{{}, {1}, {1, 2}, {1, 1}, {1, 2, 1}, {2}},
            solution.subsetsWithDup(new int[]{1, 2, 1}));
        TestSupport.assertNestedIntsIgnoringOrder(new int[][]{{}, {7}, {7, 7}},
            solution.subsetsWithDup(new int[]{7, 7}));

    }
}
