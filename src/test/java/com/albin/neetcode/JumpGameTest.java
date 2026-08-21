package com.albin.neetcode;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class JumpGameTest {

    @Test
    void neetcodeExamplesAndBoundaries() {
        var solution = new JumpGame();
        assertTrue(solution.canJump(new int[]{1, 2, 0, 1, 0}));
        assertFalse(solution.canJump(new int[]{1, 2, 1, 0, 1}));
        assertTrue(solution.canJump(new int[]{0}));

    }
}
