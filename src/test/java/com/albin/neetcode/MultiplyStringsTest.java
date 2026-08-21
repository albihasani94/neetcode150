package com.albin.neetcode;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class MultiplyStringsTest {

    @Test
    void neetcodeExamplesAndBoundaries() {
        var solution = new MultiplyStrings();
        assertEquals("12", solution.multiply("3", "4"));
        assertEquals("24642", solution.multiply("111", "222"));
        assertEquals("0", solution.multiply("0", "999"));

    }
}
