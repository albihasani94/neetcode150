package com.albin.neetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ValidAnagramTest {

    private ValidAnagram solution;

    @BeforeEach
    void setUp() {
        solution = new ValidAnagram();
    }

    @Test
    void example1_isAnagram() {
        assertTrue(solution.isAnagram("anagram", "nagaram"));
    }

    @Test
    void example2_notAnagram() {
        assertFalse(solution.isAnagram("rat", "car"));
    }

    @Test
    void emptyStrings_areAnagram() {
        assertTrue(solution.isAnagram("", ""));
    }

    @Test
    void differentLengths_notAnagram() {
        assertFalse(solution.isAnagram("a", "ab"));
    }

    @Test
    void sameString_isAnagram() {
        assertTrue(solution.isAnagram("abc", "abc"));
    }

    @Test
    void sameLengthDifferentCounts_notAnagram() {
        assertFalse(solution.isAnagram("aab", "abb"));
    }
}
