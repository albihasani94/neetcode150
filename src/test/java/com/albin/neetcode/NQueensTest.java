package com.albin.neetcode;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class NQueensTest {

    @Test
    void neetcodeExamplesAndBoundaries() {
        var solution = new NQueens();
        TestSupport.assertNestedStringsIgnoringOrder(
            new String[][]{{".Q..", "...Q", "Q...", "..Q."},
                {"..Q.", "Q...", "...Q", ".Q.."}},
            solution.solveNQueens(4));
        assertEquals(List.of(List.of("Q")), solution.solveNQueens(1));

    }
}
