package com.albin.neetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BalancedBinaryTreeTest {

    @Test
    void neetcodeExamplesAndBoundaries() {
        var solution = new BalancedBinaryTree();
        assertTrue(solution.isBalanced(TestSupport.tree(1, 2, 3, null, null, 4)));
        assertFalse(solution.isBalanced(TestSupport.tree(1, 2, 3, null, null, 4, null, 5)));
        assertTrue(solution.isBalanced(null));

    }
}
