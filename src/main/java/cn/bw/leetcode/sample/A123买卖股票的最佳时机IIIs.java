package cn.bw.leetcode.sample;

public class A123买卖股票的最佳时机IIIs {
    public int maxProfit(int[] prices) {
        int fstBuy = Integer.MAX_VALUE, sndBduy = Integer.MAX_VALUE;
        int fstSell = 0, sndSell = 0;

        for(int price: prices){
            fstBuy = Math.min(price, fstBuy);
            fstSell = Math.max(fstSell, price-fstBuy);
            sndBduy = Math.min(sndBduy, price-fstSell);
            sndSell = Math.max(sndSell, price-sndBduy);
        }

        return sndSell;
    }
}
