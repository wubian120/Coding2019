package cn.bw.leetcode.prac.p202002;

/**
 * @ClassName : A79单词搜索p0
 * @Description :
 * @Author : Richard.Wu
 * @Date:
 * 2020-02-05 13:11
 * 2020-04-15
 * 2020-04-16
 */

public class A79单词搜索p0 {


    private int[][] direction = {
            {-1, 0}, {0, -1}, {0, 1}, {1, 0}
    };

    private boolean[][] marked;
    private int rows, cols;


    public boolean exist(char[][] board, String word) {

        rows = board.length;
        if (rows == 0) return false;
        cols = board[0].length;
        marked=new boolean[rows][cols];

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(dfs(i,j,0,board,word)){
                    return true;
                }
            }
        }

        return false;
    }


    private boolean dfs(int i, int j, int start, char[][] board, String word) {
        if(start==word.length()-1){
            return board[i][j]==word.charAt(start);
        }

        if(board[i][j]==word.charAt(start)){
            marked[i][j]=true;
            for(int d=0;d<4;d++){
                int newX=i+direction[d][0];
                int newY = j+direction[d][1];

                if(in(newX,newY)&&!marked[newX][newY]){
                    if(dfs(newX,newY,start+1,board,word)){
                        return true;
                    }
                }
            }
            marked[i][j]=false;
        }
        return false;

    }

    private boolean in(int x, int y) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }

}
