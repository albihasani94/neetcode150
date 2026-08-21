package com.albin.neetcode;

/**
 * Category: Sliding Window
 *
 * <a href="https://neetcode.io/problems/buy-and-sell-crypto/question?list=neetcode150">NeetCode: Best Time to Buy and Sell Stock</a>
 */
public class BestTimeToBuyAndSellStock {

    public int maxProfit(int[] prices) {
        int minPrice = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
        }

        return maxProfit;
    }
}
