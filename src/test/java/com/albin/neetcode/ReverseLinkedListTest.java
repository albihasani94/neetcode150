package com.albin.neetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReverseLinkedListTest {

    @Test
    void neetcodeExamplesAndBoundaries() {
        var solution = new ReverseLinkedList();
        assertArrayEquals(new int[]{3, 2, 1, 0},
            TestSupport.listValues(solution.reverseList(TestSupport.list(0, 1, 2, 3))));
        assertNull(solution.reverseList(null));

    }
}
