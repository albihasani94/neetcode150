package com.albin.neetcode;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class UniquePathsTest {

    @Test
    void neetcodeExamplesAndBoundaries() {
        var solution = new UniquePaths();
        assertEquals(21, solution.uniquePaths(3, 6));
        assertEquals(6, solution.uniquePaths(3, 3));
        assertEquals(1, solution.uniquePaths(1, 8));

    }
}
