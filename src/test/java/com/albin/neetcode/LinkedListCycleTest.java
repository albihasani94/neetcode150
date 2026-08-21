package com.albin.neetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListCycleTest {

    @Test
    void neetcodeExamplesAndBoundaries() {
        var solution = new LinkedListCycle();
        ListNode cyclic = TestSupport.list(1, 2, 3, 4);
        cyclic.next.next.next.next = cyclic.next;
        assertTrue(solution.hasCycle(cyclic));
        assertFalse(solution.hasCycle(TestSupport.list(1, 2)));
        assertFalse(solution.hasCycle(null));

    }
}
