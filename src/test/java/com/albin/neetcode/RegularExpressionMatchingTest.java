package com.albin.neetcode;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class RegularExpressionMatchingTest {

    @Test
    void neetcodeExamplesAndBoundaries() {
        var solution = new RegularExpressionMatching();
        assertFalse(solution.isMatch("aa", ".b"));
        assertTrue(solution.isMatch("nnn", "n*"));
        assertTrue(solution.isMatch("xyz", ".*z"));
        assertTrue(solution.isMatch("", "a*"));

    }
}
