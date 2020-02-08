package cn.bw.leetcode.prac.p202002;

/**
 * @ClassName : A79单词搜索p1
 * @Description :
 * @Author : Richard.Wu
 * @Date: 2020-02-08 09:36
 */

public class A79单词搜索p1 {

    int[][] direct = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    String word;
    char[][] board;
    int cols, rows;
    boolean[][] marked;

    public boolean exist(char[][] board, String word) {
        rows = board.length;
        if (rows == 0) return false;
        cols = board[0].length;

        this.word = word;
        this.board = board;
        marked = new boolean[rows][cols];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (dfs(r, c, 0)) {
                    return true;
                }
            }
        }

        return false;

    }

    boolean in(int x, int y) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }

    boolean dfs(int r, int c, int start) {
        if (start == word.length() - 1) {
            return board[r][c] == word.charAt(start);
        }
        if (word.charAt(start) == board[r][c]) {
            marked[r][c]=true;
            for (int d = 0; d < 4; d++) {
                int newx=r+direct[d][0];
                int newy=c+direct[d][1];
                if(in(newx,newy)&&!marked[newx][newy]){
                    if(dfs(newx,newy,start+1)){
                        return true;
                    }
                }
            }
            marked[r][c]=false;
        }
        return false;
    }

}
