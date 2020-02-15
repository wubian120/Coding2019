package cn.bw.leetcode.prac.p202002;

/**
 * @ClassName : A122买卖股票的最佳时机IIp0
 * @Author : Richard.Wu
 * @Date: 2020-02-15 11:57
 * @Description :
 */

public class A122买卖股票的最佳时机IIp0 {

    public int maxProfit(int[] prices) {
        int len=prices.length;

        int profit=0;
        for(int i=1;i<len;i++){
            if(prices[i]-prices[i-1]<=0){
                continue;
            }else {
                profit += prices[i]-prices[i-1];
            }
        }

        return profit;

    }

}
