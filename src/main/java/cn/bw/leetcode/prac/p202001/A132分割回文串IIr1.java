package cn.bw.leetcode.prac.p202001;

/**
 * @ClassName : A132分割回文串IIr1
 * @Description :
 * @Author : Richard.Wu
 * @Date: 2020-01-29 21:26
 */

public class A132分割回文串IIr1 {


    public int minCut(String s) {
        int len = s.length();
        int[] results = new int[len];
        boolean[][] dp = new boolean[len][len];

        for (int right = 0; right < len; right++) {
            results[right] = right;
            for (int left = 0; left <= right; left++) {
                if (s.charAt(left) == s.charAt(right)) {
                    if ( (right - left <2 ||dp[left + 1][right - 1] )) {
                        dp[left][right] = true;
                        results[right] =
                                left == 0 ? 0 : Math.min(results[right],
                                        results[left - 1] + 1);
                    }
                }
            }
        }

        return results[len-1];

    }

}
