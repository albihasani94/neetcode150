package com.albin.neetcode;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class ReconstructItineraryTest {

    @Test
    void neetcodeExamplesAndBoundaries() {
        var solution = new ReconstructItinerary();
        assertEquals(List.of("JFK", "BUF", "HOU", "SEA"), solution.findItinerary(List.of(
            List.of("BUF", "HOU"), List.of("HOU", "SEA"), List.of("JFK", "BUF"))));
        assertEquals(List.of("JFK", "HOU", "JFK", "SEA", "JFK"), solution.findItinerary(List.of(
            List.of("HOU", "JFK"), List.of("SEA", "JFK"),
            List.of("JFK", "SEA"), List.of("JFK", "HOU"))));

    }
}
