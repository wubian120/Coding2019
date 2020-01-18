package cn.bw.leetcode.prac.p202001;

public class A63不同路径IIp0 {

    public int uniquePathsWithObstacles(int[][] grid) {

        int rows=grid.length;
        int cols = grid[0].length;

        int[] paths=new int[cols];

        paths[0]=1;

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]==1){
                    paths[j]=0;
                }else if(j>0){
                    paths[j] +=paths[j-1];
                }
            }
        }

        return paths[cols-1];




    }


}
