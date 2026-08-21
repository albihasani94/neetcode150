package com.albin.neetcode;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class ConstructBinaryTreeFromPreorderAndInorderTraversalTest {

    @Test
    void neetcodeExamplesAndBoundaries() {
        var solution = new ConstructBinaryTreeFromPreorderAndInorderTraversal();
        assertEquals(Arrays.asList(1, 2, 3, null, null, null, 4), TestSupport.treeValues(
            solution.buildTree(new int[]{1, 2, 3, 4}, new int[]{2, 1, 3, 4})));
        assertEquals(List.of(1), TestSupport.treeValues(solution.buildTree(new int[]{1}, new int[]{1})));

    }
}
