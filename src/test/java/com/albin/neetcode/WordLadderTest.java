package com.albin.neetcode;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class WordLadderTest {

    @Test
    void neetcodeExamplesAndBoundaries() {
        var solution = new WordLadder();
        assertEquals(4, solution.ladderLength("cat", "sag", List.of("bat", "bag", "sag", "dag", "dot")));
        assertEquals(0, solution.ladderLength("cat", "sag", List.of("bat", "bag", "sat", "dag", "dot")));

    }
}
