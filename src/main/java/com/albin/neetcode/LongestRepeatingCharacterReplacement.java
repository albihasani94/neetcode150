package com.albin.neetcode;

/**
 * Category: Sliding Window
 *
 * <a href="https://neetcode.io/problems/longest-repeating-substring-with-replacement/question?list=neetcode150">NeetCode: Longest Repeating Character Replacement</a>
 */
public class LongestRepeatingCharacterReplacement {

    public int characterReplacement(String s, int k) {
        int left = 0;
        int[] counts = new int[26];
        int longest = 0;
        int maxFrequency = 0;

        for (int right = 0; right < s.length(); right++) {
            int index = s.charAt(right) - 'A';
            counts[index]++;

            maxFrequency = Math.max(maxFrequency, counts[index]);

            while ((right - left + 1) - maxFrequency > k) {
                int leftIndex = s.charAt(left) - 'A';
                counts[leftIndex]--;
                left++;
            }

            int windowLength = right - left + 1;
            longest = Math.max(longest, windowLength);
        }
        return longest;
    }
}
