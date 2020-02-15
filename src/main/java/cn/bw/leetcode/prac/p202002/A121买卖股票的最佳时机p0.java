package cn.bw.leetcode.prac.p202002;

/**
 * @ClassName : A121买卖股票的最佳时机p0
 * @Author : Richard.Wu
 * @Date: 2020-02-15 11:23
 * @Description :
 */

public class A121买卖股票的最佳时机p0 {

    public int maxProfit(int[] prices) {
        if(prices==null || prices.length==0){
            return 0;
        }
        int len = prices.length;
        int minPrice, profit = 0;
        minPrice = prices[0];

        for (int i = 0; i < len; i++) {
            minPrice = Math.min(minPrice, prices[i]);

            profit = Math.max(profit, (prices[i] - minPrice));
        }

        return profit;

    }
}
