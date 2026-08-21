package com.albin.neetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FindTheDuplicateNumberTest {

    @Test
    void neetcodeExamplesAndBoundaries() {
        var solution = new FindTheDuplicateNumber();
        assertEquals(2, solution.findDuplicate(new int[]{1, 2, 3, 2, 2}));
        assertEquals(4, solution.findDuplicate(new int[]{1, 2, 3, 4, 4}));

    }
}
