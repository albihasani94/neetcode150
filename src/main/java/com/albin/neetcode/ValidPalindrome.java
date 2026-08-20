package com.albin.neetcode;

/**
 * <a href="https://neetcode.io/problems/is-palindrome/question?list=neetcode150">NeetCode: Valid Palindrome</a>
 */
public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;

        while (i < j) {
            while (i < j && !Character.isLetterOrDigit(s.charAt(i))) {
                i++;
            }
            while (j > i && !Character.isLetterOrDigit(s.charAt(j))) {
                j--;
            }
            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }
}
