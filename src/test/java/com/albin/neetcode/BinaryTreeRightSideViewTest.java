package com.albin.neetcode;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeRightSideViewTest {

    @Test
    void neetcodeExamplesAndBoundaries() {
        var solution = new BinaryTreeRightSideView();
        assertEquals(List.of(1, 3, 5), solution.rightSideView(TestSupport.tree(1, 2, 3, null, 4, null, 5)));
        assertEquals(List.of(1, 3, 4, 5), solution.rightSideView(TestSupport.tree(1, 2, 3, 4, null, null, null, 5)));
        assertEquals(List.of(), solution.rightSideView(null));

    }
}
