package cn.bw.leetcode.sample;

/**
 * @ClassName : A96不同的二叉搜索树s
 * @Description : leetcode 96 不同的二叉搜索树
 * @Author : Richard.Wu
 * @Date: 2020-01-25 02:08
 */

public class A96不同的二叉搜索树s {


    public int numTrees(int n) {


        //why n+1  not n?

        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] = dp[i] + dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }


}
