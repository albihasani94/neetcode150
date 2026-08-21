package com.albin.neetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReverseNodesInKGroupTest {

    @Test
    void neetcodeExamplesAndBoundaries() {
        var solution = new ReverseNodesInKGroup();
        assertArrayEquals(new int[]{3, 2, 1, 6, 5, 4}, TestSupport.listValues(
            solution.reverseKGroup(TestSupport.list(1, 2, 3, 4, 5, 6), 3)));
        assertArrayEquals(new int[]{3, 2, 1, 4, 5}, TestSupport.listValues(
            solution.reverseKGroup(TestSupport.list(1, 2, 3, 4, 5), 3)));

    }
}
