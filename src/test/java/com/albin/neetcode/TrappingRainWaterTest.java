package com.albin.neetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TrappingRainWaterTest {

    private TrappingRainWater solution;

    @BeforeEach
    void setUp() {
        solution = new TrappingRainWater();
    }

    @Test
    void neetcodeExample1() {
        int[] height = {0, 2, 0, 3, 1, 0, 1, 3, 2, 1};
        assertEquals(9, solution.trap(height));
    }

    @Test
    void leetcodeExample1() {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        assertEquals(6, solution.trap(height));
    }

    @Test
    void leetcodeExample2() {
        int[] height = {4, 2, 0, 3, 2, 5};
        assertEquals(9, solution.trap(height));
    }

    @Test
    void singleBar() {
        int[] height = {1};
        assertEquals(0, solution.trap(height));
    }

    @Test
    void twoBars() {
        int[] height = {1, 2};
        assertEquals(0, solution.trap(height));
    }

    @Test
    void noValley() {
        int[] height = {1, 2, 3};
        assertEquals(0, solution.trap(height));
    }

    @Test
    void flatHeights() {
        int[] height = {2, 2, 2};
        assertEquals(0, solution.trap(height));
    }

    @Test
    void allZeros() {
        int[] height = {0, 0, 0};
        assertEquals(0, solution.trap(height));
    }
}
