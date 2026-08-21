package com.albin.neetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AddTwoNumbersTest {

    @Test
    void neetcodeExamplesAndBoundaries() {
        var solution = new AddTwoNumbers();
        assertArrayEquals(new int[]{5, 7, 9}, TestSupport.listValues(
            solution.addTwoNumbers(TestSupport.list(1, 2, 3), TestSupport.list(4, 5, 6))));
        assertArrayEquals(new int[]{8, 1}, TestSupport.listValues(
            solution.addTwoNumbers(TestSupport.list(9), TestSupport.list(9))));

    }
}
