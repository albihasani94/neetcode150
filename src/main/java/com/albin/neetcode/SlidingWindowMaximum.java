package com.albin.neetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Category: Sliding Window
 *
 * <a href="https://neetcode.io/problems/sliding-window-maximum/question?list=neetcode150">NeetCode: Sliding Window Maximum</a>
 */
public class SlidingWindowMaximum {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        int resultIndex = 0;

        for (int right = 0; right < nums.length; right++) {
            while (!deque.isEmpty() && deque.peekFirst() <= right - k) {
                deque.removeFirst();
            }
            while (!deque.isEmpty() && nums[deque.peekLast()] <= nums[right]) {
                deque.removeLast();
            }

            deque.addLast(right);

            if (right >= k - 1) {
                result[resultIndex++] = nums[deque.peekFirst()];
            }
        }
        return result;
    }
}
