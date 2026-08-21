package com.albin.neetcode;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class DesignAddAndSearchWordsDataStructureTest {

    @Test
    void neetcodeExamplesAndBoundaries() {
        var dictionary = new WordDictionary();
        dictionary.addWord("day");
        dictionary.addWord("bay");
        dictionary.addWord("may");
        assertFalse(dictionary.search("say"));
        assertTrue(dictionary.search("day"));
        assertTrue(dictionary.search(".ay"));
        assertTrue(dictionary.search("b.."));

    }
}
