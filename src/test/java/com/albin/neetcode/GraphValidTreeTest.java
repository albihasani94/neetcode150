package com.albin.neetcode;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class GraphValidTreeTest {

    @Test
    void neetcodeExamplesAndBoundaries() {
        var solution = new GraphValidTree();
        assertTrue(solution.validTree(5, new int[][]{{0, 1}, {0, 2}, {0, 3}, {1, 4}}));
        assertFalse(solution.validTree(5, new int[][]{{0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}}));
        assertTrue(solution.validTree(1, new int[][]{}));

    }
}
