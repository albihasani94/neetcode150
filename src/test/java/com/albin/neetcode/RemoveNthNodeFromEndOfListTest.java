package com.albin.neetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RemoveNthNodeFromEndOfListTest {

    @Test
    void neetcodeExamplesAndBoundaries() {
        var solution = new RemoveNthNodeFromEndOfList();
        assertArrayEquals(new int[]{1, 2, 4}, TestSupport.listValues(
            solution.removeNthFromEnd(TestSupport.list(1, 2, 3, 4), 2)));
        assertNull(solution.removeNthFromEnd(TestSupport.list(5), 1));
        assertArrayEquals(new int[]{2}, TestSupport.listValues(
            solution.removeNthFromEnd(TestSupport.list(1, 2), 2)));

    }
}
