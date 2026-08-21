package com.albin.neetcode;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class CourseScheduleTest {

    @Test
    void neetcodeExamplesAndBoundaries() {
        var solution = new CourseSchedule();
        assertTrue(solution.canFinish(2, new int[][]{{0, 1}}));
        assertFalse(solution.canFinish(2, new int[][]{{0, 1}, {1, 0}}));

    }
}
