package com.albin.neetcode;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class MeetingRoomsIITest {

    @Test
    void neetcodeExamplesAndBoundaries() {
        var solution = new MeetingRoomsII();
        assertEquals(2, solution.minMeetingRooms(List.of(
            new Interval(0, 40), new Interval(5, 10), new Interval(15, 20))));
        assertEquals(1, solution.minMeetingRooms(List.of(new Interval(4, 9))));
        assertEquals(0, solution.minMeetingRooms(List.of()));

    }
}
