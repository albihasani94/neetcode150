package com.albin.neetcode;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class KthLargestElementInAStreamTest {

    @Test
    void neetcodeExamplesAndBoundaries() {
        var kthLargest = new KthLargest(3, new int[]{1, 2, 3, 3});
        assertEquals(3, kthLargest.add(3));
        assertEquals(3, kthLargest.add(5));
        assertEquals(3, kthLargest.add(6));
        assertEquals(5, kthLargest.add(7));
        assertEquals(6, kthLargest.add(8));

    }
}
