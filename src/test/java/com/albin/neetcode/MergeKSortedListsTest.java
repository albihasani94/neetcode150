package com.albin.neetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MergeKSortedListsTest {

    @Test
    void neetcodeExamplesAndBoundaries() {
        var solution = new MergeKSortedLists();
        ListNode[] lists = {TestSupport.list(1, 2, 4), TestSupport.list(1, 3, 5), TestSupport.list(3, 6)};
        assertArrayEquals(new int[]{1, 1, 2, 3, 3, 4, 5, 6},
            TestSupport.listValues(solution.mergeKLists(lists)));
        assertNull(solution.mergeKLists(new ListNode[0]));
        assertNull(solution.mergeKLists(new ListNode[]{null}));

    }
}
