package com.albin.neetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Category: Sliding Window
 *
 * <a href="https://neetcode.io/problems/longest-substring-without-duplicates/question?list=neetcode150">NeetCode: Longest Substring Without Repeating Characters</a>
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        int left = 0;
        Set<Character> window = new HashSet<>();

        for (int right = 0; right < s.length(); right++) {
            var ch = s.charAt(right);

            while (window.contains(ch)) {
                window.remove(s.charAt(left));
                left++;
            }

            window.add(ch);
            max = Math.max(max, window.size());
        }

        return max;
    }
}
