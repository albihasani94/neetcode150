package com.albin.neetcode;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class WordSearchIITest {

    @Test
    void neetcodeExamplesAndBoundaries() {
        var solution = new WordSearchII();
        char[][] board = {
            {'a', 'b', 'c', 'd'}, {'s', 'a', 'a', 't'},
            {'a', 'c', 'k', 'e'}, {'a', 'c', 'd', 'n'}
        };
        TestSupport.assertStringsIgnoringOrder(List.of("cat", "back", "backend"),
            solution.findWords(board, new String[]{"bat", "cat", "back", "backend", "stack"}));
        assertEquals(List.of(), solution.findWords(new char[][]{{'x', 'o'}, {'x', 'o'}},
            new String[]{"xoxo"}));

    }
}
