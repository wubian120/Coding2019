package cn.bw.leetcode.prac.p202002;

/**
 * @ClassName : A416p1
 * @Author : Richard.Wu
 * @Date: 2020-02-15 15:34
 * @Description :
 */

public class A416p1 {


    public boolean canPartition(int[] nums) {

        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        if ((sum & 1) == 1) return false;

        int half = sum / 2;
        boolean[] dp = new boolean[half + 1];
        dp[0] = true;

        for (int n : nums) {
            for (int j = half; j >= n; j--) {
                if (dp[j - n]) {
                    dp[j] = true;
                }
            }
        }


        return dp[half];

    }
}
