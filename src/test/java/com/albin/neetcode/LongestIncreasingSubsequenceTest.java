package com.albin.neetcode;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class LongestIncreasingSubsequenceTest {

    @Test
    void neetcodeExamplesAndBoundaries() {
        var solution = new LongestIncreasingSubsequence();
        assertEquals(4, solution.lengthOfLIS(new int[]{9, 1, 4, 2, 3, 3, 7}));
        assertEquals(4, solution.lengthOfLIS(new int[]{0, 3, 1, 3, 2, 3}));
        assertEquals(1, solution.lengthOfLIS(new int[]{5}));

    }
}
