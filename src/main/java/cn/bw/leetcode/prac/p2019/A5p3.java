package cn.bw.leetcode.prac.p2019;

public class A5p3 {

    public String longestPalindrome(String s) {

        if (s == null || s.length() == 0) {
            return "";
        }
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }
        int maxLen = 0, beginIndex = 0;
        for (int right = 0; right < len; right++) {
            for (int left = 0; left < right; left++) {
                if(s.charAt(left)==s.charAt(right)){
                    if (left < len - 1 && right > 0 &&
                            (dp[left + 1][right - 1] || right - left == 1)) {
                        dp[left][right] = true;
                        if (maxLen <= right - left + 1) {
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
