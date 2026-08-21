package com.albin.neetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LowestCommonAncestorOfABinarySearchTreeTest {

    @Test
    void neetcodeExamplesAndBoundaries() {
        var solution = new LowestCommonAncestorOfABinarySearchTree();
        TreeNode root = TestSupport.tree(5, 3, 8, 1, 4, 7, 9, null, 2);
        TreeNode first = solution.lowestCommonAncestor(root,
            TestSupport.find(root, 3), TestSupport.find(root, 8));
        assertNotNull(first);
        assertEquals(5, first.val);
        TreeNode second = solution.lowestCommonAncestor(root,
            TestSupport.find(root, 3), TestSupport.find(root, 4));
        assertNotNull(second);
        assertEquals(3, second.val);

    }
}
