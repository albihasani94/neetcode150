package com.albin.neetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Category: Arrays & Hashing
 *
 * <a href="https://neetcode.io/problems/duplicate-integer/question?list=neetcode150">NeetCode: Contains Duplicate</a>
 */
public class ContainsDuplicate {

    public boolean hasDuplicate(int[] nums) {
        Set<Integer> elements = HashSet.newHashSet(nums.length);
        for (int num : nums) {
            if (!elements.add(num)) {
                return true;
            }
        }
        return false;
    }
}
