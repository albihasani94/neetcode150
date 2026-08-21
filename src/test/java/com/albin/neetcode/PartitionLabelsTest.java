package com.albin.neetcode;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class PartitionLabelsTest {

    @Test
    void neetcodeExamplesAndBoundaries() {
        var solution = new PartitionLabels();
        assertEquals(List.of(5, 5, 1, 1, 1), solution.partitionLabels("xyxxyzbzbbisl"));
        assertEquals(List.of(6), solution.partitionLabels("abcabc"));

    }
}
