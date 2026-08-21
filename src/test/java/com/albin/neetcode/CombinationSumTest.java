package com.albin.neetcode;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class CombinationSumTest {

    @Test
    void neetcodeExamplesAndBoundaries() {
        var solution = new CombinationSum();
        TestSupport.assertNestedIntsIgnoringOrder(new int[][]{{2, 2, 5}, {9}},
            solution.combinationSum(new int[]{2, 5, 6, 9}, 9));
        TestSupport.assertNestedIntsIgnoringOrder(
            new int[][]{{3, 3, 3, 3, 4}, {3, 3, 5, 5}, {4, 4, 4, 4}, {3, 4, 4, 5}},
            solution.combinationSum(new int[]{3, 4, 5}, 16));
        assertEquals(List.of(), solution.combinationSum(new int[]{3}, 5));

    }
}
