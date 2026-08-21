package com.albin.neetcode;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class EditDistanceTest {

    @Test
    void neetcodeExamplesAndBoundaries() {
        var solution = new EditDistance();
        assertEquals(2, solution.minDistance("monkeys", "money"));
        assertEquals(3, solution.minDistance("neatcdee", "neetcode"));
        assertEquals(3, solution.minDistance("", "abc"));

    }
}
