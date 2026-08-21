package com.albin.neetcode;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class SumOfTwoIntegersTest {

    @Test
    void neetcodeExamplesAndBoundaries() {
        var solution = new SumOfTwoIntegers();
        assertEquals(2, solution.getSum(1, 1));
        assertEquals(11, solution.getSum(4, 7));
        assertEquals(-1, solution.getSum(-3, 2));

    }
}
