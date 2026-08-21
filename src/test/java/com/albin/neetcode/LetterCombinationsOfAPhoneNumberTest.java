package com.albin.neetcode;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class LetterCombinationsOfAPhoneNumberTest {

    @Test
    void neetcodeExamplesAndBoundaries() {
        var solution = new LetterCombinationsOfAPhoneNumber();
        TestSupport.assertStringsIgnoringOrder(
            List.of("dg", "dh", "di", "eg", "eh", "ei", "fg", "fh", "fi"),
            solution.letterCombinations("34"));
        assertEquals(List.of(), solution.letterCombinations(""));

    }
}
