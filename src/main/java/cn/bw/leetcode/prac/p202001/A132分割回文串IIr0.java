package cn.bw.leetcode.prac.p202001;

/**
 * @ClassName : A132分割回文串IIr0
 * @Description : leetcode132分割回文串II
 * @Author : Richard.Wu
 * @Date: 2020-01-25 01:56
 */

public class A132分割回文串IIr0 {


    public int minCut(String s) {

        int len = s.length();
        int[] minSteps = new int[len];
        boolean[][] dp = new boolean[len][len];

        for (int i = 0; i < len; i++) {
            minSteps[i] = i;

            for (int j = 0; j <= i; j++) {
                if (s.charAt(i) == s.charAt(j) && (i - j < 2 || dp[j + 1][i - 1])) {
                    dp[j][i] = true;
                    minSteps[i] = j == 0 ? 0 : Math.min(minSteps[i], minSteps[j - 1] + 1);
                }
            }

        }
        return minSteps[len-1];

    }
}
