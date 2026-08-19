package com.albin.neetcode;

public class ProductExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int resultI = 1;
            for (int j = 0; j < nums.length; j++) {
                if (i == j) continue;
                resultI *= nums[j];
            }
            result[i] = resultI;
        }
        return result;
    }
}
