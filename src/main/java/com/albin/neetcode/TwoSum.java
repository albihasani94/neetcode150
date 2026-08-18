package com.albin.neetcode;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> facilitator = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int diff = target - nums[i];

            if (facilitator.containsKey(diff)) {
                return new int[]{facilitator.get(diff), i};
            }

            facilitator.put(num, i);
        }

        return new int[0];
    }
}