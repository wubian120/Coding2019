package cn.bw.leetcode.prac.p202002;

/**
 * @ClassName : A96p3
 * @Author : Richard.Wu
 * @Date: 2020-02-20 21:45
 * @Description :
 */

public class A96p3 {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }

}
