package cn.bw.leetcode.prac.p202002;

/**
 * @ClassName : A887鸡蛋掉落p0
 * @Description :
 * @Author : Richard.Wu
 * @Date: 2020-02-09 07:48
 */

public class A887鸡蛋掉落p0 {

    public int superEggDrop(int K, int N) {


        int[] dp =new int[K+1];

        int f=0;
        while (dp[K]<N){

            for(int i=K;i>0;i--){
                dp[i]=dp[i]+dp[i-1]+1;
            }
            f++;
        }
        return f;

    }

}
