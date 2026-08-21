package com.albin.neetcode;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class DetectSquaresTest {

    @Test
    void neetcodeExamplesAndBoundaries() {
        var countSquares = new CountSquares();
        countSquares.add(new int[]{1, 1});
        countSquares.add(new int[]{2, 2});
        countSquares.add(new int[]{1, 2});
        assertEquals(1, countSquares.count(new int[]{2, 1}));
        assertEquals(0, countSquares.count(new int[]{3, 3}));
        countSquares.add(new int[]{2, 2});
        assertEquals(2, countSquares.count(new int[]{2, 1}));

    }
}
