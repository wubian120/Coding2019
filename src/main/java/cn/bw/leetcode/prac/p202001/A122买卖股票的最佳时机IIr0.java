package cn.bw.leetcode.prac.p202001;

/**
 * @ClassName : A122买卖股票的最佳时机IIr0
 * @Description : leetcode 122
 *
 * 从后往前走，  多次交易
 *
 *
 * @Author : Richard.Wu
 * @Date: 2020-01-23 15:21
 */

public class A122买卖股票的最佳时机IIr0 {

    public int maxProfit(int[] prices) {
        int len = prices.length;
        int maxProfit=0;
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
