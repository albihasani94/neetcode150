package com.albin.neetcode;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class RottingOrangesTest {

    @Test
    void neetcodeExamplesAndBoundaries() {
        var solution = new RottingOranges();
        assertEquals(4, solution.orangesRotting(new int[][]{{1, 1, 0}, {0, 1, 1}, {0, 1, 2}}));
        assertEquals(-1, solution.orangesRotting(new int[][]{{1, 0, 1}, {0, 2, 0}, {1, 0, 1}}));
        assertEquals(0, solution.orangesRotting(new int[][]{{0}}));

    }
}
