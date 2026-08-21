package com.albin.neetcode;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class AlienDictionaryTest {

    @Test
    void neetcodeExamplesAndBoundaries() {
        var solution = new AlienDictionary();
        assertEquals("zo", solution.foreignDictionary(new String[]{"z", "o"}));
        assertEquals("hernf", solution.foreignDictionary(
            new String[]{"hrn", "hrf", "er", "enn", "rfnn"}));
        assertEquals("", solution.foreignDictionary(new String[]{"abc", "ab"}));

    }
}
