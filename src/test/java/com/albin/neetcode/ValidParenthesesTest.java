package com.albin.neetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidParenthesesTest {

    @Test
    void neetcodeExamplesAndBoundaries() {
        var solution = new ValidParentheses();
        assertTrue(solution.isValid("[]"));
        assertTrue(solution.isValid("([{}])"));
        assertFalse(solution.isValid("[(])"));
        assertFalse(solution.isValid("("));

    }
}
