package com.albin.neetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestSubstringWithoutRepeatingCharactersTest {

    @Test
    void neetcodeExamplesAndBoundaries() {
        var solution = new LongestSubstringWithoutRepeatingCharacters();
        assertEquals(3, solution.lengthOfLongestSubstring("zxyzxyz"));
        assertEquals(1, solution.lengthOfLongestSubstring("xxxx"));
        assertEquals(0, solution.lengthOfLongestSubstring(""));

    }
}
