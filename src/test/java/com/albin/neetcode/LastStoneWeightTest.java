package com.albin.neetcode;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class LastStoneWeightTest {

    @Test
    void neetcodeExamplesAndBoundaries() {
        var solution = new LastStoneWeight();
        assertEquals(1, solution.lastStoneWeight(new int[]{2, 3, 6, 2, 4}));
        assertEquals(1, solution.lastStoneWeight(new int[]{1, 2}));
        assertEquals(5, solution.lastStoneWeight(new int[]{5}));

    }
}
