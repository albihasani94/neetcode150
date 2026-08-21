package com.albin.neetcode;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class CoinChangeTest {

    @Test
    void neetcodeExamplesAndBoundaries() {
        var solution = new CoinChange();
        assertEquals(3, solution.coinChange(new int[]{1, 5, 10}, 12));
        assertEquals(-1, solution.coinChange(new int[]{2}, 3));
        assertEquals(0, solution.coinChange(new int[]{1}, 0));

    }
}
