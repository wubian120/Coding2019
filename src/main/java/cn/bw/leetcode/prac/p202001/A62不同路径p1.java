package cn.bw.leetcode.prac.p202001;

/**
 * @ClassName : A62不同路径p1
 * @Description :
 * @Author : Richard.Wu
 * @Date: 2020-01-25 02:24
 */

public class A62不同路径p1 {

    public int uniquePaths(int m, int n) {
        if(m==0||n==0){
            return 0;
        }
        int[] dp =new int[n];
        dp[0]=1;
        for(int i=0;i<m;i++){
            for(int j=1;j<n;j++){

                dp[j] +=dp[j-1];
            }
        }

        return dp[n-1];
    }
}
