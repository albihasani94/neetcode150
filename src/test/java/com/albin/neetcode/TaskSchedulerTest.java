package com.albin.neetcode;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class TaskSchedulerTest {

    @Test
    void neetcodeExamplesAndBoundaries() {
        var solution = new TaskScheduler();
        assertEquals(5, solution.leastInterval(new char[]{'X', 'X', 'Y', 'Y'}, 2));
        assertEquals(9, solution.leastInterval(new char[]{'A', 'A', 'A', 'B', 'C'}, 3));
        assertEquals(3, solution.leastInterval(new char[]{'A', 'B', 'C'}, 0));

    }
}
