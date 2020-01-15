package cn.bw.leetcode.prac.p202001;

public class A64最小路径和p {
    public int minPathSum(int[][] grid) {

        int rows=grid.length;
        int cols = grid[0].length;
        int[][] dp =new int[rows][cols];

        dp[0][0]=grid[0][0];
        for(int r=1;r<rows;r++){
            dp[r][0]=grid[r][0]+dp[r-1][0];
        }
        for(int c=1;c<cols;c++){
            dp[0][c]=grid[0][c]+dp[0][c-1];
        }

        for(int r=1;r<rows;r++){
            for(int c=1;c<cols;c++){
                dp[r][c]=grid[r][c]+Math.min(dp[r-1][c],dp[r][c-1]);
            }
        }

        return dp[rows-1][cols-1];

    }
}
