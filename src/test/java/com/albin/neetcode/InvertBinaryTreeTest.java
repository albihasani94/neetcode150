package com.albin.neetcode;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class InvertBinaryTreeTest {

    @Test
    void neetcodeExamplesAndBoundaries() {
        var solution = new InvertBinaryTree();
        assertEquals(List.of(1, 3, 2, 7, 6, 5, 4),
            TestSupport.treeValues(solution.invertTree(TestSupport.tree(1, 2, 3, 4, 5, 6, 7))));
        assertEquals(List.of(3, 1, 2), TestSupport.treeValues(solution.invertTree(TestSupport.tree(3, 2, 1))));
        assertNull(solution.invertTree(null));

    }
}
