package com.albin.neetcode;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class GasStationTest {

    @Test
    void neetcodeExamplesAndBoundaries() {
        var solution = new GasStation();
        assertEquals(3, solution.canCompleteCircuit(new int[]{1, 2, 3, 4}, new int[]{2, 2, 4, 1}));
        assertEquals(-1, solution.canCompleteCircuit(new int[]{1, 2, 3}, new int[]{2, 3, 2}));

    }
}
