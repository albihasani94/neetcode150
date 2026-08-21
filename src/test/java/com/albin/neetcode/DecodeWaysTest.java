package com.albin.neetcode;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class DecodeWaysTest {

    @Test
    void neetcodeExamplesAndBoundaries() {
        var solution = new DecodeWays();
        assertEquals(2, solution.numDecodings("12"));
        assertEquals(0, solution.numDecodings("01"));
        assertEquals(1, solution.numDecodings("7"));

    }
}
