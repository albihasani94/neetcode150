package com.albin.neetcode;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class PartitionEqualSubsetSumTest {

    @Test
    void neetcodeExamplesAndBoundaries() {
        var solution = new PartitionEqualSubsetSum();
        assertTrue(solution.canPartition(new int[]{1, 2, 3, 4}));
        assertFalse(solution.canPartition(new int[]{1, 2, 3, 4, 5}));

    }
}
