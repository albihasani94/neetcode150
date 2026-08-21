package com.albin.neetcode;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class LongestCommonSubsequenceTest {

    @Test
    void neetcodeExamplesAndBoundaries() {
        var solution = new LongestCommonSubsequence();
        assertEquals(3, solution.longestCommonSubsequence("cat", "crabt"));
        assertEquals(4, solution.longestCommonSubsequence("abcd", "abcd"));
        assertEquals(0, solution.longestCommonSubsequence("abcd", "efgh"));

    }
}
