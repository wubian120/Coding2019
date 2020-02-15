package cn.bw.leetcode.prac.p202002;

/**
 * @ClassName : A123买卖股票的最佳时机IIIp0
 * @Author : Richard.Wu
 * @Date: 2020-02-15 12:14
 * @Description :
 */

public class A123买卖股票的最佳时机IIIp0 {

    public int maxProfit(int[] prices) {
        int fstBuy=Integer.MAX_VALUE,
                fstSell=0,
                sndBuy=Integer.MAX_VALUE,
                sndSell=0;

        for(int price:prices){
            fstBuy=Math.min(price,fstBuy);
            fstSell=Math.max(fstSell,price-fstBuy);
            sndBuy=Math.min(sndBuy,price-fstSell);
            sndSell=Math.max(sndSell,price-sndBuy);

        }

        return sndSell;

    }

}
