package com.albin.neetcode;

/**
 * Category: Binary Search
 *
 * <a href="https://neetcode.io/problems/binary-search/question?list=neetcode150">NeetCode: Binary Search</a>
 */
public class BinarySearch {

    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (target > nums[mid]) {
                low = mid + 1;
            } else if (target < nums[mid]) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
