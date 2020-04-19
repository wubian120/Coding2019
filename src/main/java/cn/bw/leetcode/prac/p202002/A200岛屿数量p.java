package cn.bw.leetcode.prac.p202002;

/**
 * @ClassName : A200岛屿数量p
 * @Author : Richard.Wu
 * @Date: 2020-04-19 10:28
 * @Description :
 *
 * 2020-04-19
 *
 *
 */

public class A200岛屿数量p {


    private int[][] direct = {
            {-1, 0}, {0, -1}, {0, 1}, {1, 0}
    };

    private boolean[][] marked;
    private int rows, cols;


    public int numIslands(char[][] grid) {
        rows=grid.length;
        if(rows==0)return 0;
        cols=grid[0].length;
        int count=0;
        marked=new boolean[rows][cols];
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(!marked[i][j]&&grid[i][j]=='1'){
                    count++;
                    dfs(i,j,grid);
                }
            }
        }

        return count;

    }

    private void dfs(int i, int j, char[][] grid){

        marked[i][j]=true;
        for(int d=0;d<4;d++){
            int newX=i+direct[d][0];
            int newY=j+direct[d][1];
            if(in(newX,newY)&&!marked[newX][newY]){

                if(grid[newX][newY]=='1'){
                    dfs(newX,newY,grid);
                }

            }
        }

    }

    private boolean in(int x, int y) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }



}
