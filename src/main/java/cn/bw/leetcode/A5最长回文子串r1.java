package cn.bw.leetcode;

public class A5最长回文子串r1 {

    public String longestPalindrome(String s) {

        if (s == null || s.length() < 2) {
            return s;
        }
        int len = s.length();
        //dp[right][left] 代表 左右 两侧是否相等
        boolean[][] dp = new boolean[len][len];
        int maxLen = 0, beginIndex = 0;

        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        for (int right = 0; right < len; right++) {
            for (int left = 0; left < right; left++) {
                if (s.charAt(right) == s.charAt(left)) {
                    //dp[left+1][right-1] 代表 向内 缩一下
                    if (left < (len - 1) && right > 0 && (dp[left + 1][right - 1] == true || (right - left == 1))) {
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
