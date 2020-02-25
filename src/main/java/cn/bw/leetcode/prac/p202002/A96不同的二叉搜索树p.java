package cn.bw.leetcode.prac.p202002;

/**
 * @ClassName : A96不同的二叉搜索树p0
 * @Description :
 * @Author : Richard.Wu
 * @Date: 2020-02-11 12:33
 *
 * 1.2020-02-24 prac
 * 2.2020-02-25 prac
 * 3.
 */

public class A96不同的二叉搜索树p {

    public int numTrees(int n) {

        int[] dp=new int[n+1];
        dp[0]=1;
        dp[1]=1;

        for(int i=2;i<=n;i++){
            for(int j=0;j<i;j++){
                dp[i]+=dp[j]*dp[i-j-1];
            }
        }

        return dp[n];



    }


}
