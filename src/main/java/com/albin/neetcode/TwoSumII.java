package com.albin.neetcode;

/**
 * <a href="https://neetcode.io/problems/two-integer-sum-ii/question?list=neetcode150">NeetCode: Two Integer Sum II</a>
 */
public class TwoSumII {

    public int[] twoSum(int[] numbers, int target) {
        int begin = 0;
        int end = numbers.length - 1;

        while (begin < end) {
            int sum = numbers[begin] + numbers[end];
            if (sum > target) {
                end--;
            } else if (sum < target) {
                begin++;
            } else {
                return new int[]{begin + 1, end + 1};
            }
        }

        return new int[0];
    }
}