package com.albin.neetcode;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class InterleavingStringTest {

    @Test
    void neetcodeExamplesAndBoundaries() {
        var solution = new InterleavingString();
        assertTrue(solution.isInterleave("aaaa", "bbbb", "aabbbbaa"));
        assertTrue(solution.isInterleave("", "", ""));
        assertFalse(solution.isInterleave("abc", "xyz", "abxzcy"));

    }
}
