package com.albin.neetcode;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class CloneGraphTest {

    @Test
    void neetcodeExamplesAndBoundaries() {
        var solution = new CloneGraph();
        int[][] adjacency = {{2}, {1, 3}, {2}};
        GraphNode original = TestSupport.graph(adjacency);
        TestSupport.assertGraphClone(original, solution.cloneGraph(original), adjacency);
        assertNull(solution.cloneGraph(null));

    }
}
