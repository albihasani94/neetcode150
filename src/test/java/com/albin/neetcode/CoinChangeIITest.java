package com.albin.neetcode;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class CoinChangeIITest {

    @Test
    void neetcodeExamplesAndBoundaries() {
        var solution = new CoinChangeII();
        assertEquals(4, solution.change(4, new int[]{1, 2, 3}));
        assertEquals(0, solution.change(7, new int[]{2, 4}));
        assertEquals(1, solution.change(0, new int[]{2, 4}));

    }
}
