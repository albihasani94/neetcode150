package com.albin.neetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ThreeSumTest {

    private ThreeSum solution;

    @BeforeEach
    void setUp() {
        solution = new ThreeSum();
    }

    @Test
    void neetcodeAndLeetcodeExample1() {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        Set<List<Integer>> normalized = normalize(solution.threeSum(nums));

        assertEquals(2, normalized.size());
        assertTrue(normalized.contains(triplet(-1, -1, 2)));
        assertTrue(normalized.contains(triplet(-1, 0, 1)));
    }

    @Test
    void neetcodeAndLeetcodeExample2_noTriplet() {
        int[] nums = {0, 1, 1};
        Set<List<Integer>> normalized = normalize(solution.threeSum(nums));

        assertTrue(normalized.isEmpty());
    }

    @Test
    void neetcodeAndLeetcodeExample3_allZeros() {
        int[] nums = {0, 0, 0};
        Set<List<Integer>> normalized = normalize(solution.threeSum(nums));

        assertEquals(1, normalized.size());
        assertTrue(normalized.contains(triplet(0, 0, 0)));
    }

    @Test
    void extraZerosStillOneTriplet() {
        int[] nums = {0, 0, 0, 0};
        Set<List<Integer>> normalized = normalize(solution.threeSum(nums));

        assertEquals(1, normalized.size());
        assertTrue(normalized.contains(triplet(0, 0, 0)));
    }

    @Test
    void noZeroSum() {
        int[] nums = {1, 2, 3};
        Set<List<Integer>> normalized = normalize(solution.threeSum(nums));

        assertTrue(normalized.isEmpty());
    }

    @Test
    void duplicateValuesProduceDistinctTriplets() {
        int[] nums = {-2, 0, 1, 1, 2};
        Set<List<Integer>> normalized = normalize(solution.threeSum(nums));

        assertEquals(2, normalized.size());
        assertTrue(normalized.contains(triplet(-2, 0, 2)));
        assertTrue(normalized.contains(triplet(-2, 1, 1)));
    }

    @Test
    void singleValidTriplet() {
        int[] nums = {1, 2, -3};
        Set<List<Integer>> normalized = normalize(solution.threeSum(nums));

        assertEquals(1, normalized.size());
        assertTrue(normalized.contains(triplet(-3, 1, 2)));
    }

    private static Set<List<Integer>> normalize(List<List<Integer>> triplets) {
        Set<List<Integer>> normalized = new HashSet<>();
        for (List<Integer> triplet : triplets) {
            List<Integer> sorted = new ArrayList<>(triplet);
            Collections.sort(sorted);
            normalized.add(sorted);
        }
        return normalized;
    }

    private static List<Integer> triplet(int a, int b, int c) {
        List<Integer> values = new ArrayList<>(List.of(a, b, c));
        Collections.sort(values);
        return values;
    }
}
