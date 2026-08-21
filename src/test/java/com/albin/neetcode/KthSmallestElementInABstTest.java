package com.albin.neetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KthSmallestElementInABstTest {

    @Test
    void neetcodeExamplesAndBoundaries() {
        var solution = new KthSmallestElementInABst();
        assertEquals(1, solution.kthSmallest(TestSupport.tree(2, 1, 3), 1));
        assertEquals(5, solution.kthSmallest(TestSupport.tree(4, 3, 5, 2, null), 4));

    }
}
