package com.albin.neetcode;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class NetworkDelayTimeTest {

    @Test
    void neetcodeExamplesAndBoundaries() {
        var solution = new NetworkDelayTime();
        assertEquals(3, solution.networkDelayTime(
            new int[][]{{1, 2, 1}, {2, 3, 1}, {1, 4, 4}, {3, 4, 1}}, 4, 1));
        assertEquals(-1, solution.networkDelayTime(new int[][]{{1, 2, 1}, {2, 3, 1}}, 3, 2));

    }
}
