package com.albin.neetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MergeTwoSortedListsTest {

    @Test
    void neetcodeExamplesAndBoundaries() {
        var solution = new MergeTwoSortedLists();
        assertArrayEquals(new int[]{1, 1, 2, 3, 4, 5}, TestSupport.listValues(
            solution.mergeTwoLists(TestSupport.list(1, 2, 4), TestSupport.list(1, 3, 5))));
        assertArrayEquals(new int[]{1, 2}, TestSupport.listValues(
            solution.mergeTwoLists(null, TestSupport.list(1, 2))));
        assertNull(solution.mergeTwoLists(null, null));

    }
}
