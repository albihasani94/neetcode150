package com.albin.neetcode;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class DesignTwitterTest {

    @Test
    void neetcodeExamplesAndBoundaries() {
        var twitter = new Twitter();
        twitter.postTweet(1, 10);
        twitter.postTweet(2, 20);
        assertEquals(List.of(10), twitter.getNewsFeed(1));
        assertEquals(List.of(20), twitter.getNewsFeed(2));
        twitter.follow(1, 2);
        assertEquals(List.of(20, 10), twitter.getNewsFeed(1));
        assertEquals(List.of(20), twitter.getNewsFeed(2));
        twitter.unfollow(1, 2);
        assertEquals(List.of(10), twitter.getNewsFeed(1));

    }
}
