package com.albin.neetcode;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class NumberOfConnectedComponentsInAnUndirectedGraphTest {

    @Test
    void neetcodeExamplesAndBoundaries() {
        var solution = new NumberOfConnectedComponentsInAnUndirectedGraph();
        assertEquals(2, solution.countComponents(5, new int[][]{{0, 1}, {1, 2}, {3, 4}}));
        assertEquals(1, solution.countComponents(5, new int[][]{{0, 1}, {1, 2}, {2, 3}, {3, 4}}));

    }
}
