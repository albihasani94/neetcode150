package com.albin.neetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ProductExceptSelfTest {

    private ProductExceptSelf solution;

    @BeforeEach
    void setUp() {
        solution = new ProductExceptSelf();
    }

    @Test
    void neetcodeExample1() {
        int[] nums = {1, 2, 4, 6};
        int[] expected = {48, 24, 12, 8};
        assertArrayEquals(expected, solution.productExceptSelf(nums));
    }

    @Test
    void neetcodeExample2() {
        int[] nums = {-1, 0, 1, 2, 3};
        int[] expected = {0, -6, 0, 0, 0};
        assertArrayEquals(expected, solution.productExceptSelf(nums));
    }

    @Test
    void leetcodeExample1() {
        int[] nums = {1, 2, 3, 4};
        int[] expected = {24, 12, 8, 6};
        assertArrayEquals(expected, solution.productExceptSelf(nums));
    }

    @Test
    void leetcodeExample2() {
        int[] nums = {-1, 1, 0, -3, 3};
        int[] expected = {0, 0, 9, 0, 0};
        assertArrayEquals(expected, solution.productExceptSelf(nums));
    }

    @Test
    void twoElements() {
        int[] nums = {2, 3};
        int[] expected = {3, 2};
        assertArrayEquals(expected, solution.productExceptSelf(nums));
    }

    @Test
    void multipleZeros() {
        int[] nums = {0, 0};
        int[] expected = {0, 0};
        assertArrayEquals(expected, solution.productExceptSelf(nums));
    }

    @Test
    void singleZero() {
        int[] nums = {0, 1, 2};
        int[] expected = {2, 0, 0};
        assertArrayEquals(expected, solution.productExceptSelf(nums));
    }

    @Test
    void allOnes() {
        int[] nums = {1, 1, 1, 1};
        int[] expected = {1, 1, 1, 1};
        assertArrayEquals(expected, solution.productExceptSelf(nums));
    }

    @Test
    void negativeNumbers() {
        int[] nums = {-2, -3, -4};
        int[] expected = {12, 8, 6};
        assertArrayEquals(expected, solution.productExceptSelf(nums));
    }
}
