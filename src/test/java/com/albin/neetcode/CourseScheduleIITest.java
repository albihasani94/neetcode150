package com.albin.neetcode;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class CourseScheduleIITest {

    @Test
    void neetcodeExamplesAndBoundaries() {
        var solution = new CourseScheduleII();
        int[][] prerequisites = {{1, 0}};
        TestSupport.assertTopologicalOrder(3, prerequisites, solution.findOrder(3, prerequisites));
        assertArrayEquals(new int[]{}, solution.findOrder(3, new int[][]{{0, 1}, {1, 2}, {2, 0}}));

    }
}
