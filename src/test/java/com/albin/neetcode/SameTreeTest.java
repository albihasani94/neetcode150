package com.albin.neetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SameTreeTest {

    @Test
    void neetcodeExamplesAndBoundaries() {
        var solution = new SameTree();
        assertTrue(solution.isSameTree(TestSupport.tree(1, 2, 3), TestSupport.tree(1, 2, 3)));
        assertFalse(solution.isSameTree(TestSupport.tree(4, 7), TestSupport.tree(4, null, 7)));
        assertFalse(solution.isSameTree(TestSupport.tree(1, 2, 3), TestSupport.tree(1, 3, 2)));
        assertTrue(solution.isSameTree(null, null));

    }
}
