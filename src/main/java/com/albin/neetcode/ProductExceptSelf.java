package com.albin.neetcode;

/**
 * Category: Arrays & Hashing
 *
 * <a href="https://neetcode.io/problems/products-of-array-discluding-self/question?list=neetcode150">NeetCode: Products of Array Except Self</a>
 */
public class ProductExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];

        result[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        int postfix = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] *= postfix;
            postfix *= nums[i];
        }

        return result;
    }
}
