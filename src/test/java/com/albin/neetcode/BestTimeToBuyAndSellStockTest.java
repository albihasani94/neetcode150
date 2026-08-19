package com.albin.neetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BestTimeToBuyAndSellStockTest {

    private BestTimeToBuyAndSellStock solution;

    @BeforeEach
    void setUp() {
        solution = new BestTimeToBuyAndSellStock();
    }

    @Test
    void neetcodeExample1() {
        int[] prices = {10, 1, 5, 6, 7, 1};
        assertEquals(6, solution.maxProfit(prices));
    }

    @Test
    void neetcodeExample2() {
        int[] prices = {10, 8, 7, 5, 2};
        assertEquals(0, solution.maxProfit(prices));
    }

    @Test
    void leetcodeExample1() {
        int[] prices = {7, 1, 5, 3, 6, 4};
        assertEquals(5, solution.maxProfit(prices));
    }

    @Test
    void leetcodeExample2() {
        int[] prices = {7, 6, 4, 3, 1};
        assertEquals(0, solution.maxProfit(prices));
    }

    @Test
    void singleDay() {
        int[] prices = {5};
        assertEquals(0, solution.maxProfit(prices));
    }

    @Test
    void twoDaysProfit() {
        int[] prices = {1, 2};
        assertEquals(1, solution.maxProfit(prices));
    }

    @Test
    void twoDaysNoProfit() {
        int[] prices = {2, 1};
        assertEquals(0, solution.maxProfit(prices));
    }

    @Test
    void allSamePrice() {
        int[] prices = {3, 3, 3};
        assertEquals(0, solution.maxProfit(prices));
    }
}
