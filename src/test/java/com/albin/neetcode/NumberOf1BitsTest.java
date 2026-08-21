package com.albin.neetcode;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class NumberOf1BitsTest {

    @Test
    void neetcodeExamplesAndBoundaries() {
        var solution = new NumberOf1Bits();
        assertEquals(4, solution.hammingWeight(0b00000000000000000000000000010111));
        assertEquals(30, solution.hammingWeight(0b01111111111111111111111111111101));
        assertEquals(0, solution.hammingWeight(0));

    }
}
