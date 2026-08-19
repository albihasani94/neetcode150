package com.albin.neetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ValidPalindromeTest {

    private ValidPalindrome solution;

    @BeforeEach
    void setUp() {
        solution = new ValidPalindrome();
    }

    @Test
    void neetcodeExample1_isPalindrome() {
        assertTrue(solution.isPalindrome("Was it a car or a cat I saw?"));
    }

    @Test
    void neetcodeExample2_notPalindrome() {
        assertFalse(solution.isPalindrome("tab a cat"));
    }

    @Test
    void leetcodeExample1_isPalindrome() {
        assertTrue(solution.isPalindrome("A man, a plan, a canal: Panama"));
    }

    @Test
    void leetcodeExample2_notPalindrome() {
        assertFalse(solution.isPalindrome("race a car"));
    }

    @Test
    void leetcodeExample3_emptyAfterFiltering() {
        assertTrue(solution.isPalindrome(" "));
    }

    @Test
    void emptyString() {
        assertTrue(solution.isPalindrome(""));
    }

    @Test
    void singleCharacter() {
        assertTrue(solution.isPalindrome("a"));
    }

    @Test
    void onlyNonAlphanumeric() {
        assertTrue(solution.isPalindrome(".,; !"));
    }

    @Test
    void alphanumericWithNumbers_false() {
        assertFalse(solution.isPalindrome("0P"));
    }

    @Test
    void alphanumericWithNumbers_true() {
        assertTrue(solution.isPalindrome("1a2a1"));
    }
}
