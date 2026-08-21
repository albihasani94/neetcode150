package com.albin.neetcode;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class HouseRobberTest {

    @Test
    void neetcodeExamplesAndBoundaries() {
        var solution = new HouseRobber();
        assertEquals(4, solution.rob(new int[]{1, 1, 3, 3}));
        assertEquals(16, solution.rob(new int[]{2, 9, 8, 3, 6}));
        assertEquals(7, solution.rob(new int[]{7}));

    }
}
