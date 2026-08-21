package com.albin.neetcode;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class WordSearchTest {

    @Test
    void neetcodeExamplesAndBoundaries() {
        var solution = new WordSearch();
        char[][] board = {{'A', 'B', 'C', 'D'}, {'S', 'A', 'A', 'T'}, {'A', 'C', 'A', 'E'}};
        assertTrue(solution.exist(board, "CAT"));
        assertFalse(solution.exist(board, "BAT"));
        assertTrue(solution.exist(new char[][]{{'A'}}, "A"));

    }
}
