package cn.bw.leetcode.sample;

/**
 * @ClassName : A200岛屿数量s
 * @Author : Richard.Wu
 * @Date: 2020-04-19 09:44
 * @Description :
 * 思路： 深度优先遍历  顺着1，在四个方向上找，只有断掉
 * //grid[newX][newY] !='1' 的时候断
 * 才会dfs 一层层往上走。
 *
 * count++ 相当于 再次遇到 等于1的情况。 即为另一个岛
 *
 */

public class A200岛屿数量s {


    private int rows, cols;
    private boolean[][] marked;
    private int[][] direct = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};


    public int numIslands(char[][] grid) {

        rows = grid.length;
        if (rows == 0) return 0;
        cols = grid[0].length;

        marked = new boolean[rows][cols];
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                //dfs
                if (!marked[i][j] && grid[i][j] == '1') {
                    count++;
                    dfs(i, j, grid);
                }
            }
        }

        return count;
    }

    private void dfs(int i, int j, char[][] grid) {

        marked[i][j] = true;
        for (int d = 0; d < 4; d++) {
            int newX = i + direct[d][0];
            int newY = j + direct[d][1];
            if(in(newX,newY)&&!marked[newX][newY]){
                //grid[newX][newY] !='1' 的时候断
                if(grid[newX][newY]=='1'){
                    dfs(newX,newY,grid);
                }
            }
        }

    }

    private boolean in(int x, int y) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }


    public static void main(String[] args){

        char[][] grid={
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };

        A200岛屿数量s a = new A200岛屿数量s();

        int result = a.numIslands(grid);

    }


}
