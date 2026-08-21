package com.albin.neetcode;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class HouseRobberIITest {

    @Test
    void neetcodeExamplesAndBoundaries() {
        var solution = new HouseRobberII();
        assertEquals(4, solution.rob(new int[]{3, 4, 3}));
        assertEquals(15, solution.rob(new int[]{2, 9, 8, 3, 6}));
        assertEquals(7, solution.rob(new int[]{7}));

    }
}
