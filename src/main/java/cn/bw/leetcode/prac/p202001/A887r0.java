package cn.bw.leetcode.prac.p202001;

/**
 * @ClassName : A887r0
 * @Description : leetcode 887 r0
 * @Author : Richard.Wu
 * @Date: 2020-01-23 18:50
 */

public class A887r0 {

    public int superEggDrop(int K, int N) {

        int[] dp = new int[K+1];
        int result =0;
        while (dp[K]<N){
            for(int i=K;i>0;i--){
                dp[i]= 1+dp[i]+dp[i-1];
            }
            result++;
        }
        return result;
    }
}
