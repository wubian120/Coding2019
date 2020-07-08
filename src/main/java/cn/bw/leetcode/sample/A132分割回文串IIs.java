package cn.bw.leetcode.sample;

/**
 * @ClassName : A132分割回文串IIs
 * @Description : leetcode 132 分割回文串II
 * 返回 符合要求的 最少分割次数。
 * 思路：
 * <p>
 * dp[i][j]   i,j 之间是 回文子串
 * 两层遍历， 左右 判断是否是回文子串， 在选择大小。
 * @Author : Richard.Wu
 * @Date: 2020-01-23 23:16
 */

public class A132分割回文串IIs {

    public int minCut(String s) {
        int len = s.length();
        int[] results = new int[len];
        boolean[][] dp = new boolean[len][len];

        for (int right = 0; right < len; right++) {
            results[right] = right;
            for (int left = 0; left <= right; left++) {
                if (s.charAt(left) == s.charAt(right)) {
                    if ((right - left < 2 || dp[left + 1][right - 1])) {
                        dp[left][right] = true;
                        // 注意这个地方 如果 left==0 则 results[right] 0
                        results[right] =
                                left == 0 ? 0 : Math.min(results[right],
                                        results[left - 1] + 1);
                    }
                }
            }
        }
        return results[len - 1];
    }

}
