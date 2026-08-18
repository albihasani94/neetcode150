package com.albin.neetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TwoSumTest {

    private void assertTwoSumEquals(int[] nums, int target, int[] expectedIndices) {
        TwoSum solver = new TwoSum();
        int[] res = solver.twoSum(nums, target);
        assertNotNull(res, "Result should not be null");
        assertEquals(2, res.length, "Result should contain exactly two indices");
        int i = res[0], j = res[1];
        assertTrue(i >= 0 && i < nums.length, "Index 0 out of bounds");
        assertTrue(j >= 0 && j < nums.length, "Index 1 out of bounds");
        assertTrue(i != j, "Indices must be distinct");
        assertEquals(target, nums[i] + nums[j], "Values at returned indices must sum to target");
        // Check the returned indices match the expected pair (order-independent)
        boolean match = (i == expectedIndices[0] && j == expectedIndices[1]) ||
                        (i == expectedIndices[1] && j == expectedIndices[0]);
        assertTrue(match, "Returned indices do not match expected pair");
    }

    @Test
    public void example1() {
        assertTwoSumEquals(new int[]{2,7,11,15}, 9, new int[]{0,1});
    }

    @Test
    public void example2() {
        assertTwoSumEquals(new int[]{3,2,4}, 6, new int[]{1,2});
    }

    @Test
    public void example3() {
        assertTwoSumEquals(new int[]{3,3}, 6, new int[]{0,1});
    }

    @Test
    public void negativesAndZero() {
        assertTwoSumEquals(new int[]{-1,0,1,2}, 1, new int[]{0,3});
    }
}
