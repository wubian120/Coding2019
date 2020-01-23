package cn.bw.leetcode.prac.p202001;

public class A121p1 {

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int len=prices.length;
        int profit=0,minPrice=prices[0];
        for(int i=1;i<len;i++){
            if(prices[i]<minPrice){
                minPrice=prices[i];
            }else {
                profit = Math.max(profit,prices[i]-minPrice);
            }
        }

        return profit;
    }
}
