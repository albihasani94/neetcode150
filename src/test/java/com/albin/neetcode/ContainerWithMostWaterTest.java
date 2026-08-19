package com.albin.neetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ContainerWithMostWaterTest {

    private ContainerWithMostWater solution;

    @BeforeEach
    void setUp() {
        solution = new ContainerWithMostWater();
    }

    @Test
    void neetcodeExample1() {
        int[] height = {1, 7, 2, 5, 4, 7, 3, 6};
        assertEquals(36, solution.maxArea(height));
    }

    @Test
    void neetcodeExample2() {
        int[] height = {2, 2, 2};
        assertEquals(4, solution.maxArea(height));
    }

    @Test
    void leetcodeExample1() {
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        assertEquals(49, solution.maxArea(height));
    }

    @Test
    void leetcodeExample2() {
        int[] height = {1, 1};
        assertEquals(1, solution.maxArea(height));
    }

    @Test
    void twoBarsDifferentHeights() {
        int[] height = {1, 2};
        assertEquals(1, solution.maxArea(height));
    }

    @Test
    void increasingHeights() {
        int[] height = {1, 2, 3, 4, 5};
        assertEquals(6, solution.maxArea(height));
    }

    @Test
    void decreasingHeights() {
        int[] height = {5, 4, 3, 2, 1};
        assertEquals(6, solution.maxArea(height));
    }

    @Test
    void zeroHeights() {
        int[] height = {0, 0};
        assertEquals(0, solution.maxArea(height));
    }
}
