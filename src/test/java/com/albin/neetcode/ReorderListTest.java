package com.albin.neetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReorderListTest {

    @Test
    void neetcodeExamplesAndBoundaries() {
        var solution = new ReorderList();
        ListNode even = TestSupport.list(2, 4, 6, 8);
        solution.reorderList(even);
        assertArrayEquals(new int[]{2, 8, 4, 6}, TestSupport.listValues(even));
        ListNode odd = TestSupport.list(2, 4, 6, 8, 10);
        solution.reorderList(odd);
        assertArrayEquals(new int[]{2, 10, 4, 8, 6}, TestSupport.listValues(odd));

    }
}
