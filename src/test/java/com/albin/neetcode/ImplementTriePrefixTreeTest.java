package com.albin.neetcode;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class ImplementTriePrefixTreeTest {

    @Test
    void neetcodeExamplesAndBoundaries() {
        var prefixTree = new PrefixTree();
        prefixTree.insert("dog");
        assertTrue(prefixTree.search("dog"));
        assertFalse(prefixTree.search("do"));
        assertTrue(prefixTree.startsWith("do"));
        prefixTree.insert("do");
        assertTrue(prefixTree.search("do"));

    }
}
