package com.albin.neetcode;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class PermutationsTest {

    @Test
    void neetcodeExamplesAndBoundaries() {
        var solution = new Permutations();
        TestSupport.assertNestedIntRowsIgnoringOrder(
            new int[][]{{1, 2, 3}, {1, 3, 2}, {2, 1, 3}, {2, 3, 1}, {3, 1, 2}, {3, 2, 1}},
            solution.permute(new int[]{1, 2, 3}));
        assertEquals(List.of(List.of(7)), solution.permute(new int[]{7}));

    }
}
