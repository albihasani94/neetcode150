package com.albin.neetcode;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class ClimbingStairsTest {

    @Test
    void neetcodeExamplesAndBoundaries() {
        var solution = new ClimbingStairs();
        assertEquals(2, solution.climbStairs(2));
        assertEquals(3, solution.climbStairs(3));
        assertEquals(1, solution.climbStairs(1));

    }
}
