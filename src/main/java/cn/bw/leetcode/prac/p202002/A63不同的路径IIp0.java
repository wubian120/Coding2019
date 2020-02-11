package cn.bw.leetcode.prac.p202002;

/**
 * @ClassName : A63不同的路径IIp0
 * @Description :
 * @Author : Richard.Wu
 * @Date: 2020-02-10 22:19
 */

public class A63不同的路径IIp0 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int rows=obstacleGrid.length;
        int cols=obstacleGrid[0].length;


        int[][] dp = new int[rows][cols];

        for(int i=0;i<rows;i++){

            dp[i][0]=obstacleGrid[i][0]==1?0:1;
        }

        for(int i=0;i<cols;i++){
            dp[0][i]=obstacleGrid[0][i]==1?0:1;
        }

        for(int r=1;r<rows;r++){
            for(int c=1;c<cols;c++){

                if(obstacleGrid[r][c]==1){
                    dp[r][c]=0;
                }else {
                    dp[r][c]=dp[r-1][c]+dp[r][c-1];
                }

            }
        }

        return dp[rows-1][cols-1];

    }

}
