package com.albin.neetcode;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class JumpGameIITest {

    @Test
    void neetcodeExamplesAndBoundaries() {
        var solution = new JumpGameII();
        assertEquals(2, solution.jump(new int[]{2, 4, 1, 1, 1, 1}));
        assertEquals(2, solution.jump(new int[]{2, 1, 2, 1, 0}));
        assertEquals(0, solution.jump(new int[]{0}));

    }
}
