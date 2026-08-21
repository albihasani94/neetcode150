package com.albin.neetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PermutationInStringTest {

    @Test
    void neetcodeExamplesAndBoundaries() {
        var solution = new PermutationInString();
        assertTrue(solution.checkInclusion("abc", "lecabee"));
        assertFalse(solution.checkInclusion("abc", "lecaabee"));
        assertFalse(solution.checkInclusion("abcd", "abc"));

    }
}
