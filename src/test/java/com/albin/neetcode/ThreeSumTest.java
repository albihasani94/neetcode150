package com.albin.neetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ThreeSumTest {

    private ThreeSum solution;

    @BeforeEach
    void setUp() {
        solution = new ThreeSum();
    }

    @Test
    void neetcodeAndLeetcodeExample1() {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        assertTripletsEqual(
                List.of(triplet(-1, -1, 2), triplet(-1, 0, 1)),
                solution.threeSum(nums)
        );
    }

    @Test
    void neetcodeAndLeetcodeExample2_noTriplet() {
        int[] nums = {0, 1, 1};
        assertTripletsEqual(List.of(), solution.threeSum(nums));
    }

    @Test
    void neetcodeAndLeetcodeExample3_allZeros() {
        int[] nums = {0, 0, 0};
        assertTripletsEqual(List.of(triplet(0, 0, 0)), solution.threeSum(nums));
    }

    @Test
    void extraZerosStillOneTriplet() {
        int[] nums = {0, 0, 0, 0};
        assertTripletsEqual(List.of(triplet(0, 0, 0)), solution.threeSum(nums));
    }

    @Test
    void noZeroSum() {
        int[] nums = {1, 2, 3};
        assertTripletsEqual(List.of(), solution.threeSum(nums));
    }

    @Test
    void duplicateValuesProduceDistinctTriplets() {
        int[] nums = {-2, 0, 1, 1, 2};
        assertTripletsEqual(
                List.of(triplet(-2, 0, 2), triplet(-2, 1, 1)),
                solution.threeSum(nums)
        );
    }

    @Test
    void singleValidTriplet() {
        int[] nums = {1, 2, -3};
        assertTripletsEqual(List.of(triplet(-3, 1, 2)), solution.threeSum(nums));
    }

    private static void assertTripletsEqual(List<List<Integer>> expected, List<List<Integer>> actual) {
        assertEquals(normalize(expected), normalize(actual));
    }

    private static Map<List<Integer>, Long> normalize(List<List<Integer>> triplets) {
        return triplets.stream()
                .map(triplet -> {
                    List<Integer> sorted = new ArrayList<>(triplet);
                    Collections.sort(sorted);
                    return List.copyOf(sorted);
                })
                .collect(Collectors.groupingBy(triplet -> triplet, Collectors.counting()));
    }

    private static List<Integer> triplet(int a, int b, int c) {
        List<Integer> values = new ArrayList<>(List.of(a, b, c));
        Collections.sort(values);
        return values;
    }
}
