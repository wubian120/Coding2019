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

        int begin = 0, maxlen = 0;
        int len = s.length();
        boolean[][] dp = new boolean[len][len];

        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        for (int r = 0; r < len; r++) {
            for (int l = 0; l < r; l++) {
                if (s.charAt(r) == s.charAt(l)) {
                    if (r > 0 && l < len - 1 && (dp[l + 1][r - 1] || r - l == 1)) {
                        dp[l][r] = true;

                        if (r - l + 1 > maxlen) {
                            maxlen = r - l + 1;
                            begin = l;
                        }
                    }
                }
            }
        }
        if (maxlen == 0 && begin == 0) {
            return "" + s.charAt(0);
        }

        return s.substring(begin, begin + maxlen);

    }
}
