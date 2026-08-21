package com.albin.neetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TimeBasedKeyValueStoreTest {

    @Test
    void neetcodeExamplesAndBoundaries() {
        var timeMap = new TimeMap();
        timeMap.set("alice", "happy", 1);
        assertEquals("happy", timeMap.get("alice", 1));
        assertEquals("happy", timeMap.get("alice", 2));
        timeMap.set("alice", "sad", 3);
        assertEquals("sad", timeMap.get("alice", 3));
        assertEquals("", timeMap.get("missing", 3));

    }
}
