package cn.bw.leetcode.prac.p202001;

/**
 * @ClassName : A123p0
 * @Description : leetcode 123 买卖股票的最佳时机III
 * @Author : Richard.Wu
 * @Date: 2020-01-23 15:51
 */

public class A123p0 {

    public int maxProfit(int[] prices) {

        int fstBuy=Integer.MAX_VALUE,sndBuy=Integer.MAX_VALUE;
        int fstSell=0, sndSell=0;

        for(int price:prices){
            fstBuy = Math.min(fstBuy,price);
            fstSell= Math.max(fstSell, price-fstBuy);
            sndBuy=Math.min(sndBuy,price-fstSell);
            sndSell = Math.max(sndSell,price-sndBuy);
        }
        return sndSell;

    }

}
