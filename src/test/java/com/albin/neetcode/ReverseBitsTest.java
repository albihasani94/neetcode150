package com.albin.neetcode;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class ReverseBitsTest {

    @Test
    void neetcodeExamplesAndBoundaries() {
        var solution = new ReverseBits();
        assertEquals(Integer.reverse(0b00000000000000000000000000010101),
            solution.reverseBits(0b00000000000000000000000000010101));
        assertEquals(0, solution.reverseBits(0));

    }
}
