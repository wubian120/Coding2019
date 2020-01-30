package cn.bw.leetcode.prac.p202001;

/**
 * @ClassName : A887鸡蛋掉落r1
 * @Description :
 * @Author : Richard.Wu
 * @Date: 2020-01-30 12:56
 */

public class A887鸡蛋掉落r1 {

    public int superEggDrop(int K, int N) {

        int[] dp =new int[K+1];
        int result=0;

        while (dp[K]<N){
            for(int i=K;i>0;i--){
                dp[i]=dp[i]+dp[i-1]+1;
            }
            result++;
        }

        return result;


    }
}
