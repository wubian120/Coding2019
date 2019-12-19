package cn.bw.leetcode;

public class A5最长回文子串S {
    public String longestPalindrome(String s) {

        int len = s.length();
        if (len < 2 || s == null) {
            return s;
        }
        boolean[][] dp = new boolean[len][len];
        int maxLen = 0;
        int begin = 0;
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
        }

        for (int right = 0; right < len; right++) {
            for (int left = 0; left < right; left++) {
                if (s.charAt(right) == s.charAt(left)) {
                    if (left < len - 1 && right > 0 &&
                            (dp[left + 1][right - 1] == true || (right - left == 1))) {
                        dp[left][right] = true;
                        if (maxLen < right - left + 1) {
                            maxLen = right - left + 1;
                            begin = left;
                        }
                    }
                }
            }
        }
        if (maxLen == 0 && begin == 0) {
            return s.charAt(0) + "";
        }
        return s.substring(begin, begin + maxLen);
    }

    public static void main(String... args) {

        String s = "babad";
        A5最长回文子串S a = new A5最长回文子串S();
        String result = a.longestPalindrome(s);
        System.out.println(result);


    }
}
