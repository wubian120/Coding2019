package cn.bw.leetcode.prac.p202002;

/**
 * @ClassName : A63不同的路径IIp0
 * @Description :
 * @Author : Richard.Wu
 * @Date: 2020-02-10 22:19
 */

public class A63不同的路径IIp0 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {


        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;

        int[] dp = new int[cols];
        dp[0] = 1;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (obstacleGrid[r][c] == 1) {
                    dp[c] = 0;
                } else if (c > 0) {
                    dp[c] += dp[c - 1];
                }
            }
        }

        return dp[cols-1];


    }

}
