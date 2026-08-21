package com.albin.neetcode;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class TargetSumTest {

    @Test
    void neetcodeExamplesAndBoundaries() {
        var solution = new TargetSum();
        assertEquals(3, solution.findTargetSumWays(new int[]{2, 2, 2}, 2));
        assertEquals(1, solution.findTargetSumWays(new int[]{1}, -1));

    }
}
