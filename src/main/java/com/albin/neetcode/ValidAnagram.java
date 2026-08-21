package com.albin.neetcode;

import java.util.*;

/**
 * Category: Arrays & Hashing
 *
 * <a href="https://neetcode.io/problems/is-anagram/question?list=neetcode150">NeetCode: Valid Anagram</a>
 */
public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        var lettersS = s.toCharArray();
        var lettersT = t.toCharArray();

        Arrays.sort(lettersS);
        Arrays.sort(lettersT);

        return String.valueOf(lettersS).equals(String.valueOf(lettersT));
    }
}
