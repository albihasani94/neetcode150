package com.albin.neetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MaximumDepthOfBinaryTreeTest {

    @Test
    void neetcodeExamplesAndBoundaries() {
        var solution = new MaximumDepthOfBinaryTree();
        assertEquals(3, solution.maxDepth(TestSupport.tree(1, 2, 3, null, null, 4)));
        assertEquals(0, solution.maxDepth(null));

    }
}
