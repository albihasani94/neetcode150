package com.albin.neetcode;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class RotateImageTest {

    @Test
    void neetcodeExamplesAndBoundaries() {
        var solution = new RotateImage();
        int[][] twoByTwo = {{1, 2}, {3, 4}};
        solution.rotate(twoByTwo);
        TestSupport.assertMatrixEquals(new int[][]{{3, 1}, {4, 2}}, twoByTwo);
        int[][] threeByThree = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        solution.rotate(threeByThree);
        TestSupport.assertMatrixEquals(new int[][]{{7, 4, 1}, {8, 5, 2}, {9, 6, 3}}, threeByThree);

    }
}
