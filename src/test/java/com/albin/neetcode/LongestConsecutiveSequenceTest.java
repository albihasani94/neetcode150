package com.albin.neetcode;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LongestConsecutiveSequenceTest {

    @Test
    public void example1() {
        LongestConsecutiveSequence s = new LongestConsecutiveSequence();
        assertEquals(4, s.longestConsecutive(new int[]{100,4,200,1,3,2}));
    }

    @Test
    public void example2() {
        LongestConsecutiveSequence s = new LongestConsecutiveSequence();
        assertEquals(9, s.longestConsecutive(new int[]{0,3,7,2,5,8,4,6,0,1}));
    }
}
