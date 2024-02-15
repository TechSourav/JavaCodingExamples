package org.sourav.Leetcode.SlidingWindow;

public class BuySellStock {

    public static void main(String[] args) {
        int[] arr = {7,1,5,3,6,4};
        System.out.println(maxProfit(arr));
    }

    public static int maxProfit(int[] prices) {
        int l = 0;
        int len = prices.length;
        int maxPro = 0;
        for (int r = 0; r < len; r++) {
            if (prices[l] < prices[r]) {
                maxPro = Math.max(maxPro, (prices[r] - prices[l]));
            } else {
                l = r;
            }
        }
        return maxPro;
    }

}
