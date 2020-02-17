package cn.bw.leetcode.prac.p202002;

/**
 * @ClassName : A887p2
 * @Author : Richard.Wu
 * @Date: 2020-02-17 15:17
 * @Description :
 */

public class A887p2 {


    public int superEggDrop(int K, int N) {

        int[] dp = new int[K + 1];

        int result = 0;
        while (dp[K] < N) {
            for (int i = K; i >= 0; i--) {
                dp[i] = dp[i] + dp[i - 1] + 1;
            }
            result++;
        }

        return result;

    }
}
