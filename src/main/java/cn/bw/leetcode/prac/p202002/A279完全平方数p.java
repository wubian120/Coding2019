package cn.bw.leetcode.prac.p202002;

import java.util.Arrays;

/**
 * @ClassName : A279完全平方数p
 * @Author : Richard.Wu
 * @Date: 2020-04-25 10:44
 * @Description :
 * <p>
 * 2020-04-25
 */

public class A279完全平方数p {

    public int numSquares(int n) {

        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {

                dp[i]=Math.min(dp[i],dp[i-j*j]+1);
            }
        }

        return dp[n];
    }


}
