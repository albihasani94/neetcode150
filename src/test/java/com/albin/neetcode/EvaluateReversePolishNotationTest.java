package com.albin.neetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EvaluateReversePolishNotationTest {

    @Test
    void neetcodeExamplesAndBoundaries() {
        var solution = new EvaluateReversePolishNotation();
        assertEquals(5, solution.evalRPN(new String[]{"1", "2", "+", "3", "*", "4", "-"}));
        assertEquals(-1, solution.evalRPN(new String[]{"4", "-5", "+"}));

    }
}
