package com.albin.neetcode;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class BurstBalloonsTest {

    @Test
    void neetcodeExamplesAndBoundaries() {
        var solution = new BurstBalloons();
        assertEquals(143, solution.maxCoins(new int[]{4, 2, 3, 7}));
        assertEquals(5, solution.maxCoins(new int[]{5}));

    }
}
