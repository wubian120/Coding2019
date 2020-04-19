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
    public int uniquePaths(int rows, int cols) {

        int[] dp = new int[cols];

        dp[0]=1;
        for(int r=0;r<rows;r++){

            for(int c=1;c<cols;c++){
                dp[c]+=dp[c-1];
            }
        }


        return dp[cols-1];



    }
}
