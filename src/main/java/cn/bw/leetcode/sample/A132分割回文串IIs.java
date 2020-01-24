package cn.bw.leetcode.sample;

/**
 * @ClassName : A132分割回文串IIs
 * @Description : leetcode 132 分割回文串II
 * @Author : Richard.Wu
 * @Date: 2020-01-23 23:16
 */

public class A132分割回文串IIs {


    public int minCut(String s) {
        int n = s.length();
        int[] min_s = new int[n];
        boolean[][] dp = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            min_s[i] = i;
            for (int j = 0; j <= i; j++) {
                if (s.charAt(i) == s.charAt(j) && (i - j < 2 || dp[j + 1][i - 1])) {
                    dp[j][i] = true;
                    min_s[i] = j == 0 ? 0 : Math.min(min_s[i], min_s[j - 1] + 1);
                }
            }
        }
        return min_s[n - 1];
    }

}
