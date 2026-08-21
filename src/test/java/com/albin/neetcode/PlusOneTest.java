package com.albin.neetcode;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class PlusOneTest {

    @Test
    void neetcodeExamplesAndBoundaries() {
        var solution = new PlusOne();
        assertArrayEquals(new int[]{1, 2, 3, 5}, solution.plusOne(new int[]{1, 2, 3, 4}));
        assertArrayEquals(new int[]{1, 0, 0, 0}, solution.plusOne(new int[]{9, 9, 9}));

    }
}
