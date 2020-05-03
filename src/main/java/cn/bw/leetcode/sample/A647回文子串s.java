package cn.bw.leetcode.sample;

/**
 * @ClassName : A647回文子串s
 * @Author : Richard.Wu
 * @Date: 2020-05-02 10:11
 * @Description :
 */

public class A647回文子串s {


    // dp 解法

    public int countSubstrings(String s) {

        int len = s.length();
        int maxLen = 0;
        boolean[][] dp = new boolean[len][len];

        for (int r = 0; r < len; r++) {
            /// 容易错   l<=r
            for (int l = 0; l <= r; l++) {
                if (s.charAt(r) == s.charAt(l)) {
                    if (r - l < 2 || dp[l + 1][r - 1]) {
                        dp[l][r] = true;
                        maxLen++;
                    }
                }
            }
        }

        return maxLen;
    }

}
