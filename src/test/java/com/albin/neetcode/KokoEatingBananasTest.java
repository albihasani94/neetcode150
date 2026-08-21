package com.albin.neetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KokoEatingBananasTest {

    @Test
    void neetcodeExamplesAndBoundaries() {
        var solution = new KokoEatingBananas();
        assertEquals(2, solution.minEatingSpeed(new int[]{1, 4, 3, 2}, 9));
        assertEquals(25, solution.minEatingSpeed(new int[]{25, 10, 23, 4}, 4));

    }
}
