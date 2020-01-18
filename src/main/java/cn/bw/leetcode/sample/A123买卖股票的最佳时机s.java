package cn.bw.leetcode.sample;

public class A123买卖股票的最佳时机s {

    public int maxProfit(int[] prices) {
        int len = prices.length;
        int profit = 0;
        int minPrice = Integer.MAX_VALUE;
        for(int i=0;i<len;i++){
            if(prices[i] < minPrice){
                minPrice = prices[i];
            }
            if(prices[i]-minPrice > profit){
                profit = prices[i] - minPrice;
            }

        }
        return profit;
    }
}



