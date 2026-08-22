package com.albin.neetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Category: Sliding Window
 *
 * <a href="https://neetcode.io/problems/minimum-window-with-characters/question?list=neetcode150">NeetCode: Minimum Window Substring</a>
 */
public class MinimumWindowSubstring {

    public String minWindow(String s, String t) {
        if (t.isEmpty() || s.length() < t.length()) {
            return "";
        }

        Map<Character, Integer> needs = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for (char ch : t.toCharArray()) {
            needs.merge(ch, 1, Integer::sum);
        }

        int left = 0;
        int bestStart = 0;
        int bestLength = Integer.MAX_VALUE;

        int required = needs.size();
        int have = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            if (needs.containsKey(c)) {
                window.merge(c, 1, Integer::sum);
                if (window.get(c).equals(needs.get(c))) {
                    have++;
                }
            }

            while (have == required) {
                int windowLength = right - left + 1;
                if (windowLength < bestLength) {
                    bestStart = left;
                    bestLength = windowLength;
                }

                char removed = s.charAt(left);
                if (needs.containsKey(removed)) {
                    window.merge(removed, -1, Integer::sum);
                    if (window.get(removed) < needs.get(removed)) {
                        have--;
                    }
                }
                left++;
            }
        }
        return bestLength == Integer.MAX_VALUE ? "" : s.substring(bestStart, bestStart + bestLength);
    }
}
