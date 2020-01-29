package cn.bw.leetcode.sample;

/**
 * @ClassName : A132分割回文串IIs
 * @Description : leetcode 132 分割回文串II
 * 返回 符合要求的 最少分割次数。
 * 思路：
 *
 * dp[i][j]   i,j 之间是 回文子串
 * 两层遍历， 左右 判断是否是回文子串， 在选择大小。
 *
 *
 *
 *
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
