package com.albin.neetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LongestConsecutiveSequenceTest {

    private LongestConsecutiveSequence solution;

    @BeforeEach
    void setUp() {
        solution = new LongestConsecutiveSequence();
    }

    @Test
    void neetcodeExample1() {
        int[] nums = {2, 20, 4, 10, 3, 4, 5};
        assertEquals(4, solution.longestConsecutive(nums));
    }

    @Test
    void neetcodeExample2() {
        int[] nums = {0, 3, 2, 5, 4, 6, 1, 1};
        assertEquals(7, solution.longestConsecutive(nums));
    }

    @Test
    void leetcodeExample1() {
        int[] nums = {100, 4, 200, 1, 3, 2};
        assertEquals(4, solution.longestConsecutive(nums));
    }

    @Test
    void leetcodeExample2() {
        int[] nums = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
        assertEquals(9, solution.longestConsecutive(nums));
    }

    @Test
    void emptyArray() {
        int[] nums = {};
        assertEquals(0, solution.longestConsecutive(nums));
    }

    @Test
    void singleElement() {
        int[] nums = {10};
        assertEquals(1, solution.longestConsecutive(nums));
    }

    @Test
    void allDuplicates() {
        int[] nums = {1, 1, 1, 1};
        assertEquals(1, solution.longestConsecutive(nums));
    }

    @Test
    void duplicateAtEndOfLongestSequence() {
        int[] nums = {1, 2, 2};
        assertEquals(2, solution.longestConsecutive(nums));
    }

    @Test
    void negativeNumbers() {
        int[] nums = {-5, -4, -3, -2, -1, 0, 1};
        assertEquals(7, solution.longestConsecutive(nums));
    }

    @Test
    void unorderedWithNegatives() {
        int[] nums = {-1, -2, -3, 0, 1, 2};
        assertEquals(6, solution.longestConsecutive(nums));
    }
}
