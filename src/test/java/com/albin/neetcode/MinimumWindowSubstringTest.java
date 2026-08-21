package com.albin.neetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinimumWindowSubstringTest {

    @Test
    void neetcodeExamplesAndBoundaries() {
        var solution = new MinimumWindowSubstring();
        assertEquals("YXAZ", solution.minWindow("OUZODYXAZV", "XYZ"));
        assertEquals("xyz", solution.minWindow("xyz", "xyz"));
        assertEquals("", solution.minWindow("x", "xy"));

    }
}
