package com.albin.neetcode;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class ReverseIntegerTest {

    @Test
    void neetcodeExamplesAndBoundaries() {
        var solution = new ReverseInteger();
        assertEquals(4321, solution.reverse(1234));
        assertEquals(-4321, solution.reverse(-1234));
        assertEquals(0, solution.reverse(1234236467));
        assertEquals(0, solution.reverse(0));

    }
}
