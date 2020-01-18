package cn.bw.leetcode.prac.p202001;

public class A123买卖股票的最佳时机IIIr {

    public int maxProfit(int[] prices) {
        int fstBuy=Integer.MAX_VALUE;
        int sndBuy = Integer.MAX_VALUE;
        int fstSell = 0, sndSell=0;

        for(int price:prices){
            fstBuy = Math.min(fstBuy,price);
            fstSell = Math.max(fstSell,price-fstBuy);
            sndBuy = Math.min(sndBuy,price-fstSell);
            sndSell = Math.max(sndSell,price-sndBuy);
        }


        return sndSell;

    }
}
