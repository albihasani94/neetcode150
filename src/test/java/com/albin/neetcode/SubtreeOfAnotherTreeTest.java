package com.albin.neetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SubtreeOfAnotherTreeTest {

    @Test
    void neetcodeExamplesAndBoundaries() {
        var solution = new SubtreeOfAnotherTree();
        assertTrue(solution.isSubtree(TestSupport.tree(1, 2, 3, 4, 5), TestSupport.tree(2, 4, 5)));
        assertFalse(solution.isSubtree(TestSupport.tree(1, 2, 3, 4, 5, null, null, 6),
            TestSupport.tree(2, 4, 5)));

    }
}
