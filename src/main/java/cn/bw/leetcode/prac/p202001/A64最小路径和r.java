package cn.bw.leetcode.prac.p202001;

public class A64最小路径和r {

    public int minPathSum(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int[][] dp =new int[rows][cols];
        dp[0][0] =grid[0][0];

        for(int i=1;i<rows;i++){
            dp[i][0] = grid[i][0]+dp[i-1][0];
        }

        for(int i=1;i<cols;i++){
            dp[0][i]=grid[0][i]+dp[0][i-1];
        }

        for(int c=1;c<cols;c++){
            for(int r=1;r<rows;r++){
                dp[r][c]=grid[r][c]+Math.min(dp[r-1][c],dp[r][c-1]);
            }
        }

        return dp[rows-1][cols-1];

    }

}
