package com.albin.neetcode;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class RedundantConnectionTest {

    @Test
    void neetcodeExamplesAndBoundaries() {
        var solution = new RedundantConnection();
        assertArrayEquals(new int[]{2, 4},
            solution.findRedundantConnection(new int[][]{{1, 2}, {1, 3}, {3, 4}, {2, 4}}));
        assertArrayEquals(new int[]{3, 4},
            solution.findRedundantConnection(new int[][]{{1, 2}, {1, 3}, {1, 4}, {3, 4}, {4, 5}}));

    }
}
