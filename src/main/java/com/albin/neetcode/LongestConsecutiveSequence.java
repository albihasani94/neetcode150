package com.albin.neetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LongestConsecutiveSequence {

    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        Arrays.sort(nums);

        int currentConsecutive = nums[0];
        int maxConsecutive = 1;

        List<Integer> consecutiveMaxCounts = new ArrayList<>();
        consecutiveMaxCounts.add(maxConsecutive);

        for (int i = 1; i < nums.length; i++) {
            if (nums [i] == currentConsecutive) continue;

            if (nums[i] == currentConsecutive + 1) {
                maxConsecutive++;
                if (i == nums.length - 1) {
                    consecutiveMaxCounts.add(maxConsecutive);
                }
            } else {
                consecutiveMaxCounts.add(maxConsecutive);
                maxConsecutive = 1;
            }
            currentConsecutive = nums[i];
        }

        return consecutiveMaxCounts.stream().max(Comparator.naturalOrder()).orElse(0);
    }
}
