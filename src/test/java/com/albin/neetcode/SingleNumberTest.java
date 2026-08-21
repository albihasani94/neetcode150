package com.albin.neetcode;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class SingleNumberTest {

    @Test
    void neetcodeExamplesAndBoundaries() {
        var solution = new SingleNumber();
        assertEquals(2, solution.singleNumber(new int[]{3, 2, 3}));
        assertEquals(8, solution.singleNumber(new int[]{7, 6, 6, 7, 8}));

    }
}
