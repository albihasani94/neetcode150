package com.albin.neetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidateBinarySearchTreeTest {

    @Test
    void neetcodeExamplesAndBoundaries() {
        var solution = new ValidateBinarySearchTree();
        assertTrue(solution.isValidBST(TestSupport.tree(2, 1, 3)));
        assertFalse(solution.isValidBST(TestSupport.tree(1, 2, 3)));

    }
}
