package cn.bw.leetcode.prac.p202001;

/**
 * @ClassName : A70p2
 * @Description : leetcode 70 爬楼梯
 * @Author : Richard.Wu
 * @Date: 2020-01-25 02:19
 */

public class A70p2 {
    public int climbStairs(int n) {

        if(n<=2){
            return n;
        }

        int[] dp =new int[n+1];
        dp[1]=1;
        dp[2]=2;
        for(int i=3;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }

        return dp[n];

    }
}
