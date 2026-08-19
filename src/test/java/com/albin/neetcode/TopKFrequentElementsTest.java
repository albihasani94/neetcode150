package com.albin.neetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class TopKFrequentElementsTest {

    private TopKFrequentElements solution;

    @BeforeEach
    void setUp() {
        solution = new TopKFrequentElements();
    }

    @Test
    void example1_returnsTwoMostFrequent() {
        assertTopKFrequentEquals(new int[]{1, 2, 2, 3, 3, 3}, 2, new int[]{2, 3});
    }

    @Test
    void example2_singleRepeatedValue() {
        assertTopKFrequentEquals(new int[]{7, 7}, 1, new int[]{7});
    }

    @Test
    void leetcodeExample1() {
        assertTopKFrequentEquals(new int[]{1, 1, 1, 2, 2, 3}, 2, new int[]{1, 2});
    }

    @Test
    void leetcodeExample2() {
        assertTopKFrequentEquals(new int[]{1}, 1, new int[]{1});
    }

    @Test
    void singleElement() {
        assertTopKFrequentEquals(new int[]{42}, 1, new int[]{42});
    }

    @Test
    void allSameValue() {
        assertTopKFrequentEquals(new int[]{5, 5, 5, 5}, 1, new int[]{5});
    }

    @Test
    void kEqualsDistinctCount() {
        assertTopKFrequentEquals(new int[]{1, 2, 3}, 3, new int[]{1, 2, 3});
    }

    @Test
    void handlesNegativeValues() {
        assertTopKFrequentEquals(new int[]{-1, -1, 2}, 2, new int[]{-1, 2});
    }

    private void assertTopKFrequentEquals(int[] nums, int k, int[] expected) {
        int[] result = solution.topKFrequent(nums, k);
        assertNotNull(result, "Result should not be null");
        assertEquals(k, result.length, "Result length should equal k");

        int[] actualSorted = Arrays.stream(result).sorted().toArray();
        int[] expectedSorted = Arrays.stream(expected).sorted().toArray();
        assertArrayEquals(
                expectedSorted,
                actualSorted,
                "Result should contain the k most frequent elements (any order)"
        );
    }
}
