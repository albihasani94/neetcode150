package com.albin.neetcode;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class FindMedianFromDataStreamTest {

    @Test
    void neetcodeExamplesAndBoundaries() {
        var medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        assertEquals(1.0, medianFinder.findMedian());
        medianFinder.addNum(3);
        assertEquals(2.0, medianFinder.findMedian());
        medianFinder.addNum(2);
        assertEquals(2.0, medianFinder.findMedian());

    }
}
