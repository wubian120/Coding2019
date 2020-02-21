package cn.bw.leetcode.sample;

public class A44通配符匹配s {


    ///https://leetcode-cn.com/problems/wildcard-matching/solution/shuang-zhi-zhen-he-dong-tai-gui-hua-by-powcai/
    public boolean isMatch2(String s, String p) {


        /// dp[i][j] 表示 p的前j 是否可以和 s的 前i 匹配。
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;

        for (int j = 1; j < p.length() + 1; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1];
            }
        }

        for (int i = 1; i < s.length() + 1; i++) {
            for (int j = 1; j < p.length() + 1; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1)
                        || p.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                }
            }
        }
        return dp[s.length()][p.length()];

    }


    //dp 解法
    public boolean isMatch(String text, String pattern) {
        // 多一维的空间，因为求 dp[len - 1][j] 的时候需要知道 dp[len][j] 的情况，
        // 多一维的话，就可以把 对 dp[len - 1][j] 也写进循环了
        boolean[][] dp = new boolean[2][pattern.length() + 1];
        dp[text.length() % 2][pattern.length()] = true;

        // 从 len 开始减少
        for (int i = text.length(); i >= 0; i--) {
            for (int j = pattern.length(); j >= 0; j--) {
                if (i == text.length() && j == pattern.length())
                    continue;
                boolean first_match = (i < text.length() && j < pattern.length() && (pattern.charAt(j) == text.charAt(i)
                        || pattern.charAt(j) == '?' || pattern.charAt(j) == '*'));
                if (j < pattern.length() && pattern.charAt(j) == '*') {
                    dp[i % 2][j] = dp[i % 2][j + 1] || first_match && dp[(i + 1) % 2][j];
                } else {
                    dp[i % 2][j] = first_match && dp[(i + 1) % 2][j + 1];
                }
            }
        }
        return dp[0][0];
    }


    public boolean isMatch0(String text, String pattern) {
        // 多一维的空间，因为求 dp[len - 1][j] 的时候需要知道 dp[len][j] 的情况，
        // 多一维的话，就可以把 对 dp[len - 1][j] 也写进循环了
        boolean[][] dp = new boolean[text.length() + 1][pattern.length() + 1];
        // dp[len][len] 代表两个空串是否匹配了，"" 和 "" ，当然是 true 了。
        dp[text.length()][pattern.length()] = true;

        // 从 len 开始减少
        for (int i = text.length(); i >= 0; i--) {
            for (int j = pattern.length(); j >= 0; j--) {
                // dp[text.length()][pattern.length()] 已经进行了初始化
                if (i == text.length() && j == pattern.length())
                    continue;
                //相比之前增加了判断是否等于 *
                boolean first_match = (i < text.length() && j < pattern.length() && (pattern.charAt(j) == text.charAt(i) || pattern.charAt(j) == '?' || pattern.charAt(j) == '*'));
                if (j < pattern.length() && pattern.charAt(j) == '*') {
                    //将 * 跳过 和将字符匹配一个并且 pattern 不变两种情况
                    dp[i][j] = dp[i][j + 1] || first_match && dp[i + 1][j];
                } else {
                    dp[i][j] = first_match && dp[i + 1][j + 1];
                }
            }
        }
        return dp[0][0];
    }


}
