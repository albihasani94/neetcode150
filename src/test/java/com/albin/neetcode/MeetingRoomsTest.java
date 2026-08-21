package com.albin.neetcode;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class MeetingRoomsTest {

    @Test
    void neetcodeExamplesAndBoundaries() {
        var solution = new MeetingRooms();
        assertFalse(solution.canAttendMeetings(List.of(
            new Interval(0, 30), new Interval(5, 10), new Interval(15, 20))));
        assertTrue(solution.canAttendMeetings(List.of(new Interval(5, 8), new Interval(9, 15))));
        assertTrue(solution.canAttendMeetings(List.of(new Interval(0, 8), new Interval(8, 10))));

    }
}
