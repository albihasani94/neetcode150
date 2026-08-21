package com.albin.neetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinStackTest {

    @Test
    void neetcodeExamplesAndBoundaries() {
        var stack = new MinStack();
        stack.push(1);
        stack.push(2);
        stack.push(0);
        assertEquals(0, stack.getMin());
        stack.pop();
        assertEquals(2, stack.top());
        assertEquals(1, stack.getMin());
        stack.push(1);
        assertEquals(1, stack.getMin());

    }
}
