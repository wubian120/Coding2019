package cn.bw.leetcode.prac.p202002;

/**
 * @ClassName : A63p1
 * @Author : Richard.Wu
 * @Date: 2020-02-19 09:09
 * @Description :
 */

public class A63p1 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int rows = obstacleGrid.length;
        if (rows == 0) return 0;
        int cols = obstacleGrid[0].length;

        int[] dp = new int[cols];
        dp[0] = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[j] = 0;
                } else if (j > 0) {
                    dp[j] += dp[j - 1];
                }
            }
        }
        return dp[cols - 1];
    }


}
