package com.albin.neetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarFleetTest {

    @Test
    void neetcodeExamplesAndBoundaries() {
        var solution = new CarFleet();
        assertEquals(1, solution.carFleet(10, new int[]{1, 4}, new int[]{3, 2}));
        assertEquals(3, solution.carFleet(10, new int[]{4, 1, 0, 7}, new int[]{2, 2, 1, 1}));

    }
}
