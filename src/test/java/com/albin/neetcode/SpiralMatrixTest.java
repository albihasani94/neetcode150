package com.albin.neetcode;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class SpiralMatrixTest {

    @Test
    void neetcodeExamplesAndBoundaries() {
        var solution = new SpiralMatrix();
        assertEquals(List.of(1, 2, 4, 3), solution.spiralOrder(new int[][]{{1, 2}, {3, 4}}));
        assertEquals(List.of(1, 2, 3, 6, 9, 8, 7, 4, 5),
            solution.spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
        assertEquals(List.of(1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7),
            solution.spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}}));

    }
}
