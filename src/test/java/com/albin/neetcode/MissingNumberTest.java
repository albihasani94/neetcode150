package com.albin.neetcode;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class MissingNumberTest {

    @Test
    void neetcodeExamplesAndBoundaries() {
        var solution = new MissingNumber();
        assertEquals(0, solution.missingNumber(new int[]{1, 2, 3}));
        assertEquals(1, solution.missingNumber(new int[]{0, 2}));
        assertEquals(0, solution.missingNumber(new int[]{}));

    }
}
