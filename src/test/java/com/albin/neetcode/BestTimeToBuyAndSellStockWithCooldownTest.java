package com.albin.neetcode;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class BestTimeToBuyAndSellStockWithCooldownTest {

    @Test
    void neetcodeExamplesAndBoundaries() {
        var solution = new BestTimeToBuyAndSellStockWithCooldown();
        assertEquals(6, solution.maxProfit(new int[]{1, 3, 4, 0, 4}));
        assertEquals(0, solution.maxProfit(new int[]{1}));

    }
}
