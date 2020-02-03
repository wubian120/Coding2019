package cn.bw.leetcode.prac.p202001;

/**
 * @ClassName : A887鸡蛋掉落p1
 * @Description :
 * @Author : Richard.Wu
 * @Date: 2020-02-01 22:28
 */

public class A887鸡蛋掉落p1 {


    public int superEggDrop(int K, int N) {

        int[] dp = new int[K+1];
        int result=0;

        while (dp[K]<N){

            for(int i=K;i>0;i--){

                dp[i]=1+dp[i]+dp[i-1];

            }
            result++;
        }

        return result;

    }


}
