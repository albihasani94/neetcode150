package com.albin.neetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeMaximumPathSumTest {

    @Test
    void neetcodeExamplesAndBoundaries() {
        var solution = new BinaryTreeMaximumPathSum();
        assertEquals(6, solution.maxPathSum(TestSupport.tree(1, 2, 3)));
        assertEquals(40, solution.maxPathSum(TestSupport.tree(-15, 10, 20, null, null, 15, 5, -5)));

    }
}
