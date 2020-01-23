package cn.bw.leetcode.sample;

public class A122买卖股票的最佳时机IIs {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;

        int len = prices.length;
        for(int i=len-1;i>0;i--){
            if(prices[i]<prices[i-1]){
                continue;
            }else {
                maxProfit += prices[i]-prices[i-1];
            }
        }

        return maxProfit;
    }



}
