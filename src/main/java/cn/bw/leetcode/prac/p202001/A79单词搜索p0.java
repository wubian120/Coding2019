package cn.bw.leetcode.prac.p202001;

/**
 * @ClassName : A79单词搜索p0
 * @Description :
 * @Author : Richard.Wu
 * @Date: 2020-01-30 11:29
 */

public class A79单词搜索p0 {

    boolean[][] marked;
    int rows, cols;
    String word;

    char[][] board;
    int[][] direct = {
            {-1, 0}, {0, -1}, {0, 1}, {1, 0}
    };

    private boolean in(int x, int y) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }

    private boolean dfs(int x, int y, int start) {
        if (word.length() - 1 == start) {
            return board[x][y] == word.charAt(start);
        }

        if (word.charAt(start) == board[x][y]) {
            marked[x][y] = true;
            for (int d = 0; d < 4; d++) {
                int newX = x + direct[d][0];
                int newY = y + direct[d][1];
                if(in(newX,newY) && !marked[newX][newY]){

                    if(dfs(newX,newY,start+1)){
                        return true;
                    }
                }
            }
            marked[x][y]=false;
        }
        return false;


    }

    public boolean exist(char[][] board, String word) {
        rows=board.length;
        if(rows==0){
            return false;
        }
        cols=board[0].length;
        this.word=word;
        this.board=board;
        this.marked=new boolean[rows][cols];

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(dfs(i,j,0)){
                    return true;
                }
            }
        }

        return false;

    }


}
