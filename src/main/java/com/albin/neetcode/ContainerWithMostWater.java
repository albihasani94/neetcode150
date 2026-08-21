package com.albin.neetcode;

/**
 * <a href="https://neetcode.io/problems/max-water-container/question?list=neetcode150">NeetCode: Container With Most Water</a>
 */
public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int maxArea = 0;

        while (l < r) {
            int area = (r - l) * Math.min(height[l], height[r]);
            maxArea = Math.max(maxArea, area);
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return maxArea;
    }
}
