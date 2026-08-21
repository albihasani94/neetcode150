package com.albin.neetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestRepeatingCharacterReplacementTest {

    @Test
    void neetcodeExamplesAndBoundaries() {
        var solution = new LongestRepeatingCharacterReplacement();
        assertEquals(4, solution.characterReplacement("XYYX", 2));
        assertEquals(5, solution.characterReplacement("AAABABB", 1));
        assertEquals(1, solution.characterReplacement("ABCDE", 0));

    }
}
