package com.albin.neetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ContainsDuplicateTest {

    private ContainsDuplicate solution;

    @BeforeEach
    void setUp() {
        solution = new ContainsDuplicate();
    }

    @Test
    void neetcodeExample1_hasDuplicate() {
        assertTrue(solution.hasDuplicate(new int[]{1, 2, 3, 3}));
    }

    @Test
    void neetcodeExample2_noDuplicate() {
        assertFalse(solution.hasDuplicate(new int[]{1, 2, 3, 4}));
    }

    @Test
    void example1_hasDuplicate() {
        assertTrue(solution.hasDuplicate(new int[]{1, 2, 3, 1}));
    }

    @Test
    void example2_noDuplicate() {
        assertFalse(solution.hasDuplicate(new int[]{1, 2, 3, 4}));
    }

    @Test
    void example3_hasDuplicate() {
        assertTrue(solution.hasDuplicate(new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2}));
    }

    @Test
    void emptyArray_noDuplicate() {
        assertFalse(solution.hasDuplicate(new int[]{}));
    }

    @Test
    void singleElement_noDuplicate() {
        assertFalse(solution.hasDuplicate(new int[]{1}));
    }
}
