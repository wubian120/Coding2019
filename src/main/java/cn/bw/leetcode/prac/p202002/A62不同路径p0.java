package cn.bw.leetcode.prac.p202002;

/**
 * @ClassName : A62不同路径p0
 * @Description :
 * @Author : Richard.Wu
 * @Date: 2020-02-10 22:02
 * <p>
 * 2020-04-12
 */

public class A62不同路径p0 {
    public int uniquePaths(int m, int n) {


        int[] dp = new int[n];
        dp[0]=1;

        for(int i=0;i<m;i++){
            for(int j=1;j<n;j++){

                dp[j]+=dp[j-1];
            }
        }

        return dp[n-1];


    }
}
