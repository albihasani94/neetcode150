package com.albin.neetcode;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class PalindromePartitioningTest {

    @Test
    void neetcodeExamplesAndBoundaries() {
        var solution = new PalindromePartitioning();
        TestSupport.assertNestedStringsIgnoringOrder(new String[][]{{"a", "a", "b"}, {"aa", "b"}},
            solution.partition("aab"));
        assertEquals(List.of(List.of("a")), solution.partition("a"));

    }
}
