package com.albin.neetcode;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class HandOfStraightsTest {

    @Test
    void neetcodeExamplesAndBoundaries() {
        var solution = new HandOfStraights();
        assertTrue(solution.isNStraightHand(new int[]{1, 2, 4, 2, 3, 5, 3, 4}, 4));
        assertFalse(solution.isNStraightHand(new int[]{1, 2, 3, 3, 4, 5, 6, 7}, 4));

    }
}
