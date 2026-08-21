package com.albin.neetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LRUCacheTest {

    @Test
    void neetcodeExamplesAndBoundaries() {
        var cache = new LRUCache(2);
        cache.put(1, 10);
        assertEquals(10, cache.get(1));
        cache.put(2, 20);
        cache.put(3, 30);
        assertEquals(20, cache.get(2));
        assertEquals(-1, cache.get(1));
        cache.put(2, 25);
        assertEquals(25, cache.get(2));

    }
}
