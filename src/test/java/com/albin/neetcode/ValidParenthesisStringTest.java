package com.albin.neetcode;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class ValidParenthesisStringTest {

    @Test
    void neetcodeExamplesAndBoundaries() {
        var solution = new ValidParenthesisString();
        assertTrue(solution.checkValidString("((**)"));
        assertFalse(solution.checkValidString("(((*)"));
        assertTrue(solution.checkValidString("*"));

    }
}
