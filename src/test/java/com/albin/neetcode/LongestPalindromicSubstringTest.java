package com.albin.neetcode;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class LongestPalindromicSubstringTest {

    @Test
    void neetcodeExamplesAndBoundaries() {
        var solution = new LongestPalindromicSubstring();
        String palindrome = solution.longestPalindrome("ababd");
        assertNotNull(palindrome);
        assertTrue(Set.of("aba", "bab").contains(palindrome));
        assertEquals("bb", solution.longestPalindrome("abbc"));
        assertEquals("x", solution.longestPalindrome("x"));

    }
}
