package com.albin.neetcode;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class CountingBitsTest {

    @Test
    void neetcodeExamplesAndBoundaries() {
        var solution = new CountingBits();
        assertArrayEquals(new int[]{0, 1, 1, 2, 1}, solution.countBits(4));
        assertArrayEquals(new int[]{0}, solution.countBits(0));

    }
}
