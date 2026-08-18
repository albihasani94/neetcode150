package com.albin.neetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ValidPalindromeTest {

    @Test
    public void exampleTrue() {
        ValidPalindrome v = new ValidPalindrome();
        assertTrue(v.isPalindrome("A man, a plan, a canal: Panama"));
    }

    @Test
    public void exampleFalse() {
        ValidPalindrome v = new ValidPalindrome();
        assertFalse(v.isPalindrome("race a car"));
    }

    @Test
    public void edgeCases() {
        ValidPalindrome v = new ValidPalindrome();
        assertTrue(v.isPalindrome(""));
        assertTrue(v.isPalindrome("a"));
    }
}
