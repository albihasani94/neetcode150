package com.albin.neetcode;

import java.util.Arrays;

/**
 * Category: Sliding Window
 *
 * <a href="https://neetcode.io/problems/permutation-string/question?list=neetcode150">NeetCode: Permutation In String</a>
 */
public class PermutationInString {

    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        int[] frequencies = new int[26];
        for (char c : s1.toCharArray()) {
            frequencies[c - 'a']++;
        }

        int[] window = new int[26];

        for (int i = 0; i < s2.length(); i++) {
            window[s2.charAt(i) - 'a']++;

            if (i >= s1.length()) {
                window[s2.charAt(i - s1.length()) - 'a']--;
            }

            if (i >= s1.length() - 1 && Arrays.equals(frequencies, window)) {
                return true;
            }
        }

        return false;
    }
}
