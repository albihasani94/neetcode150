package com.albin.neetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class TwoSumIITest {

    private TwoSumII solution;

    @BeforeEach
    void setUp() {
        solution = new TwoSumII();
    }

    @Test
    void neetcodeExample1() {
        int[] numbers = {1, 2, 3, 4};
        assertArrayEquals(new int[]{1, 2}, solution.twoSum(numbers, 3));
    }

    @Test
    void leetcodeExample1() {
        int[] numbers = {2, 7, 11, 15};
        assertArrayEquals(new int[]{1, 2}, solution.twoSum(numbers, 9));
    }

    @Test
    void leetcodeExample2() {
        int[] numbers = {2, 3, 4};
        assertArrayEquals(new int[]{1, 3}, solution.twoSum(numbers, 6));
    }

    @Test
    void leetcodeExample3() {
        int[] numbers = {-1, 0};
        assertArrayEquals(new int[]{1, 2}, solution.twoSum(numbers, -1));
    }

    @Test
    void twoEqualNumbers() {
        int[] numbers = {5, 5};
        assertArrayEquals(new int[]{1, 2}, solution.twoSum(numbers, 10));
    }

    @Test
    void pairAtOppositeEnds() {
        int[] numbers = {1, 3, 4, 7, 11};
        assertArrayEquals(new int[]{1, 5}, solution.twoSum(numbers, 12));
    }

    @Test
    void negativeNumbers() {
        int[] numbers = {-5, -3, -1};
        assertArrayEquals(new int[]{1, 2}, solution.twoSum(numbers, -8));
    }
}
