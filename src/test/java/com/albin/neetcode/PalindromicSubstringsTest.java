package com.albin.neetcode;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class PalindromicSubstringsTest {

    @Test
    void neetcodeExamplesAndBoundaries() {
        var solution = new PalindromicSubstrings();
        assertEquals(3, solution.countSubstrings("abc"));
        assertEquals(6, solution.countSubstrings("aaa"));
        assertEquals(1, solution.countSubstrings("x"));

    }
}
