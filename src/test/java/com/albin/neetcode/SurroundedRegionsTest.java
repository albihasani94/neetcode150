package com.albin.neetcode;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class SurroundedRegionsTest {

    @Test
    void neetcodeExamplesAndBoundaries() {
        var solution = new SurroundedRegions();
        char[][] board = {
            {'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'},
            {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}
        };
        solution.solve(board);
        TestSupport.assertMatrixEquals(new char[][]{
            {'X', 'X', 'X', 'X'}, {'X', 'X', 'X', 'X'},
            {'X', 'X', 'X', 'X'}, {'X', 'O', 'X', 'X'}
        }, board);
        char[][] single = {{'X'}};
        solution.solve(single);
        TestSupport.assertMatrixEquals(new char[][]{{'X'}}, single);

    }
}
