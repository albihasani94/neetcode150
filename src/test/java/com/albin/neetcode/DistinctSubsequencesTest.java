package com.albin.neetcode;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class DistinctSubsequencesTest {

    @Test
    void neetcodeExamplesAndBoundaries() {
        var solution = new DistinctSubsequences();
        assertEquals(3, solution.numDistinct("caaat", "cat"));
        assertEquals(5, solution.numDistinct("xxyxy", "xy"));
        assertEquals(1, solution.numDistinct("abc", ""));

    }
}
