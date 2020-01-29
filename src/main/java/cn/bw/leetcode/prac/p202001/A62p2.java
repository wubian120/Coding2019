package cn.bw.leetcode.prac.p202001;

/**
 * @ClassName : A62p2
 * @Description :
 * @Author : Richard.Wu
 * @Date: 2020-01-29 09:00
 */

public class A62p2 {

    public int uniquePaths(int m, int n) {
        if(m==0||n==0){
            return 0;
        }

        int[] dp = new int[n];

        dp[0]=1;
        for(int i=0;i<m;i++){
            for(int j=1;j<n;j++){
                dp[j] += dp[j-1];
            }
        }

        return dp[n-1];
    }


}
