package com.albin.neetcode;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        Set<Integer> numbers = new HashSet<>();
        for (int number : nums) {
            numbers.add(number); // eliminated duplicates
        }

        int longest = 0;

        for (int number : numbers) {
            boolean hasPredecessor = numbers.contains(number - 1);

            if (hasPredecessor) {
                continue;
            }

            int current = number;
            int length = 1;

            while (numbers.contains(current + 1)) {
                current++;
                length++;
            }

            longest = Math.max(longest, length);
        }

        return longest;
    }
}
