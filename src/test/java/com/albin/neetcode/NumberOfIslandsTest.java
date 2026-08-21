package com.albin.neetcode;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class NumberOfIslandsTest {

    @Test
    void neetcodeExamplesAndBoundaries() {
        var solution = new NumberOfIslands();
        char[][] oneIsland = {
            {'0', '1', '1', '1', '0'}, {'0', '1', '0', '1', '0'},
            {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}
        };
        assertEquals(1, solution.numIslands(oneIsland));
        char[][] fourIslands = {
            {'1', '1', '0', '0', '1'}, {'1', '1', '0', '0', '1'},
            {'0', '0', '1', '0', '0'}, {'0', '0', '0', '1', '1'}
        };
        assertEquals(4, solution.numIslands(fourIslands));

    }
}
