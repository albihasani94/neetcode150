package com.albin.neetcode;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class CombinationSumIITest {

    @Test
    void neetcodeExamplesAndBoundaries() {
        var solution = new CombinationSumII();
        TestSupport.assertNestedIntsIgnoringOrder(new int[][]{{1, 2, 5}, {2, 2, 4}, {2, 6}},
            solution.combinationSum2(new int[]{9, 2, 2, 4, 6, 1, 5}, 8));
        TestSupport.assertNestedIntsIgnoringOrder(new int[][]{{1, 2, 4}, {2, 5}, {3, 4}},
            solution.combinationSum2(new int[]{1, 2, 3, 4, 5}, 7));

    }
}
