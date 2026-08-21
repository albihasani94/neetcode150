package com.albin.neetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiameterOfBinaryTreeTest {

    @Test
    void neetcodeExamplesAndBoundaries() {
        var solution = new DiameterOfBinaryTree();
        assertEquals(3, solution.diameterOfBinaryTree(TestSupport.tree(1, null, 2, 3, 4, 5)));
        assertEquals(2, solution.diameterOfBinaryTree(TestSupport.tree(1, 2, 3)));

    }
}
