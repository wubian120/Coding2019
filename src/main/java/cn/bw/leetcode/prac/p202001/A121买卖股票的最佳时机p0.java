package cn.bw.leetcode.prac.p202001;

public class A121买卖股票的最佳时机p0 {

    public int maxProfit(int[] prices) {

        int len=prices.length;
        int profit = 0;
        int minPrice = 99999999;
        for(int i=0;i<len;i++){
            if(prices[i]<minPrice){
                minPrice = prices[i];
            }
            profit = Math.max(prices[i]-minPrice, profit);

        }
        return profit;

    }
}
