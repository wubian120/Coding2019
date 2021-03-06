package cn.bw.leetcode.prac.p2019;

public class A5最长回文子串p2 {

    public String longestPalindrome(String s) {

        if (s == null || s.length() == 0) {
            return "";
        }
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        int maxLen = 0, beginIndex = 0;
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        for (int right = 0; right < len; right++) {
            for (int left = 0; left < right; left++) {
                if (s.charAt(left) == s.charAt(right)) {
                    if (left + 1 < len
                            && right > 0
                            && (dp[left + 1][right - 1] || right - left == 1)) {
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
            return s.charAt(0) + "";
        }
        return s.substring(beginIndex, beginIndex + maxLen);


    }
}
