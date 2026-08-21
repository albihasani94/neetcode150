package com.albin.neetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SearchA2DMatrixTest {

    @Test
    void neetcodeExamplesAndBoundaries() {
        var solution = new SearchA2DMatrix();
        int[][] matrix = {{1, 2, 4, 8}, {10, 11, 12, 13}, {14, 20, 30, 40}};
        assertTrue(solution.searchMatrix(matrix, 10));
        assertFalse(solution.searchMatrix(matrix, 15));

    }
}
