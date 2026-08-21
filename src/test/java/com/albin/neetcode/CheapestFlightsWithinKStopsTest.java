package com.albin.neetcode;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class CheapestFlightsWithinKStopsTest {

    @Test
    void neetcodeExamplesAndBoundaries() {
        var solution = new CheapestFlightsWithinKStops();
        assertEquals(500, solution.findCheapestPrice(4,
            new int[][]{{0, 1, 200}, {1, 2, 100}, {1, 3, 300}, {2, 3, 100}}, 0, 3, 1));
        assertEquals(200, solution.findCheapestPrice(3,
            new int[][]{{1, 0, 100}, {1, 2, 200}, {0, 2, 100}}, 1, 2, 1));

    }
}
