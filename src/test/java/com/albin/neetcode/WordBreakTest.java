package com.albin.neetcode;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class WordBreakTest {

    @Test
    void neetcodeExamplesAndBoundaries() {
        var solution = new WordBreak();
        assertTrue(solution.wordBreak("neetcode", List.of("neet", "code")));
        assertTrue(solution.wordBreak("applepenapple", List.of("apple", "pen", "ape")));
        assertFalse(solution.wordBreak("catsincars", List.of("cats", "cat", "sin", "in", "car")));

    }
}
