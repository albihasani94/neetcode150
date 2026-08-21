package com.albin.neetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CountGoodNodesInBinaryTreeTest {

    @Test
    void neetcodeExamplesAndBoundaries() {
        var solution = new CountGoodNodesInBinaryTree();
        assertEquals(3, solution.goodNodes(TestSupport.tree(2, 1, 1, 3, null, 1, 5)));
        assertEquals(4, solution.goodNodes(TestSupport.tree(1, 2, -1, 3, 4)));

    }
}
