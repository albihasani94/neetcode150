package com.albin.neetcode;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class SetMatrixZeroesTest {

    @Test
    void neetcodeExamplesAndBoundaries() {
        var solution = new SetMatrixZeroes();
        int[][] first = {{0, 1}, {1, 0}};
        solution.setZeroes(first);
        TestSupport.assertMatrixEquals(new int[][]{{0, 0}, {0, 0}}, first);
        int[][] second = {{1, 2, 3}, {4, 0, 5}, {6, 7, 8}};
        solution.setZeroes(second);
        TestSupport.assertMatrixEquals(new int[][]{{1, 0, 3}, {0, 0, 0}, {6, 0, 8}}, second);

    }
}
