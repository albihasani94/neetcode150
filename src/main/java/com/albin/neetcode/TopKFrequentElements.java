package com.albin.neetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * Category: Arrays & Hashing
 *
 * <a href="https://neetcode.io/problems/top-k-elements-in-list/question?list=neetcode150">NeetCode: Top K Frequent Elements</a>
 */
public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencies = new HashMap<>();

        for (int num : nums) {
            frequencies.merge(num, 1, Integer::sum);
        }

        return frequencies.entrySet()
                .stream()
                .sorted(byMaxCount())
                .limit(k)
                .mapToInt(Map.Entry::getKey)
                .toArray();
    }

    private static Comparator<Map.Entry<Integer, Integer>> byMaxCount() {
        return (a , b) -> Integer.compare(b.getValue(), a.getValue());
    }
}
