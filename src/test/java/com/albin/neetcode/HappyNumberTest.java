package com.albin.neetcode;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class HappyNumberTest {

    @Test
    void neetcodeExamplesAndBoundaries() {
        var solution = new HappyNumber();
        assertTrue(solution.isHappy(100));
        assertFalse(solution.isHappy(101));
        assertTrue(solution.isHappy(1));

    }
}
