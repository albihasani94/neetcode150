package com.albin.neetcode;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class GenerateParenthesesTest {

    @Test
    void neetcodeExamplesAndBoundaries() {
        var solution = new GenerateParentheses();
        TestSupport.assertStringsIgnoringOrder(List.of("()"), solution.generateParenthesis(1));
        TestSupport.assertStringsIgnoringOrder(
            List.of("((()))", "(()())", "(())()", "()(())", "()()()"),
            solution.generateParenthesis(3));

    }
}
