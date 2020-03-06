package cn.bw.leetcode.prac.p202002;

/**
 * @ClassName : A5最长回文子串p0
 * @Description :
 * @Author : Richard.Wu
 * @Date: 2020-02-09 07:54
 */

public class A5最长回文子串p {

    public String longestPalindrome(String s) {

        if (s == null || s.length() < 2) {
            return s;
        }

        int len = s.length();
        int beginIndex = 0;
        int maxLen = 0;
        boolean[][] dp = new boolean[len][len];

        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        for (int right = 0; right < len; right++) {
            for (int left = 0; left < right; left++) {

                if (s.charAt(right) == s.charAt(left)) {
                    if (right > 0 && left < len - 1 && (dp[left + 1][right - 1] || right-left==1)) {
                        dp[left][right] = true;

                        if (maxLen < right - left + 1) {
                            maxLen = right - left + 1;
                            beginIndex = left;
                        }

                    }
                }
            }
        }

        if (maxLen == 0 && beginIndex == 0) {
            return "" + s.charAt(0);
        }

        return s.substring(beginIndex, beginIndex + maxLen);


    }
}
