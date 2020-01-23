package cn.bw.leetcode.sample;

/**
 * @ClassName : A188买卖股票的最佳时机IVs
 * @Description : leetcode 买卖股票的最佳时机IV
 * @Author : Richard.Wu
 * @Date: 2020-01-23 18:23
 */

public class A188买卖股票的最佳时机IVs {

    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length < 1 || k < 1) {
            return 0;
        }
        if (k > prices.length >> 1) {
            return maxProfit(prices);
        }
        // 初始化 dp 数组,第 i 天，第 k 笔 交易，是否持有股票,1 持有，0 不持有
        int[][][] mp = new int[prices.length][k + 1][2];
        // 初始化第一天数据，买入股票
        for (int i = 1; i < k+1; i++) {
            mp[0][i][1] = -prices[0];
        }
        // 依次递归最大收益
        for (int i = 1; i < prices.length; i++) {
            for (int j = 1; j <= k; j++) {
                // 第 i 天，第 j 笔 交易，不持有股票的最大值=
                // 前一天持有股票今天卖出 / 前一天不持有股票，保持不变
                mp[i][j][0] = Math.max(mp[i - 1][j][0], mp[i - 1][j][1] + prices[i]);
                // 第 i 天，第 j 笔 交易，持有股票的最大值=
                // 前一天不持有股票今天买入 / 前一天持有股票，保持不变
                mp[i][j][1] = Math.max(mp[i - 1][j][1], mp[i - 1][j - 1][0] - prices[i]);
            }
        }
        return mp[prices.length - 1][k][0]; // 最大利润
    }
    // 不限制交易次数
    public int maxProfit(int[] prices) {
        int profit = 0;
        // 贪婪算法，存在利润就卖出
        for (int i = 0; i < prices.length-1; i++) {
            if (prices[i] < prices[i + 1]) {
                profit += prices[i + 1] - prices[i];
            }
        }
        return profit;
    }



    ////

    /***
     *
     * @param max_k
     * @param prices
     * @return
     */
    public int maxProfit1(int max_k, int[] prices) {
        int n = prices.length;
        if (max_k > n / 2)
            return maxProfit_k_inf(prices);

        int[][][] dp = new int[n][max_k + 1][2];
        for (int i = 0; i < n; i++)
            for (int k = max_k; k >= 1; k--) {
                if (i - 1 == -1) {
                    /* 处理 base case */
                    dp[i][k][0] = 0;
                    dp[i][k][1] = -prices[i];
                    continue;
                }
                dp[i][k][0] = Math.max(dp[i-1][k][0], dp[i-1][k][1] + prices[i]);
                dp[i][k][1] = Math.max(dp[i-1][k][1], dp[i-1][k-1][0] - prices[i]);
            }
        return dp[n - 1][max_k][0];

    }

    int maxProfit_k_inf(int[] prices) {
        int n = prices.length;
        int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int temp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, temp - prices[i]);
        }
        return dp_i_0;
    }





}
