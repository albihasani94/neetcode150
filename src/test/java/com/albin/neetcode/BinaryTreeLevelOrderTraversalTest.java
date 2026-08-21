package com.albin.neetcode;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeLevelOrderTraversalTest {

    @Test
    void neetcodeExamplesAndBoundaries() {
        var solution = new BinaryTreeLevelOrderTraversal();
        assertEquals(List.of(List.of(1), List.of(2, 3), List.of(4, 5, 6, 7)),
            solution.levelOrder(TestSupport.tree(1, 2, 3, 4, 5, 6, 7)));
        assertEquals(List.of(List.of(1)), solution.levelOrder(TestSupport.tree(1)));
        assertEquals(List.of(), solution.levelOrder(null));

    }
}
