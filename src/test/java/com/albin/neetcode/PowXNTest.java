package com.albin.neetcode;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class PowXNTest {

    @Test
    void neetcodeExamplesAndBoundaries() {
        var solution = new PowXN();
        assertEquals(32.0, solution.myPow(2.0, 5), 1e-9);
        assertEquals(2.59374, solution.myPow(1.1, 10), 1e-5);
        assertEquals(0.125, solution.myPow(2.0, -3), 1e-9);

    }
}
