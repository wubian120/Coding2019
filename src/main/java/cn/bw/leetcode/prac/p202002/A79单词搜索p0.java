package cn.bw.leetcode.prac.p202002;

/**
 * @ClassName : A79单词搜索p0
 * @Description :
 * @Author : Richard.Wu
 * @Date: 2020-02-05 13:11
 */

public class A79单词搜索p0 {


    int rows = 0, cols = 0;
    char[][] board;
    String word;
    int[][] direct = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    boolean[][] marked;

    public boolean exist(char[][] board, String word) {
        rows = board.length;
        if (rows == 0) {
            return false;
        }
        cols = board[0].length;

        marked = new boolean[rows][cols];
        this.word = word;
        this.board = board;

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

    private boolean dfs(int r, int c, int start) {
        if (start == word.length() - 1) {
            return board[r][c] == word.charAt(start);
        }

        if (board[r][c] == word.charAt(start)) {
            marked[r][c] = true;
            for (int d = 0; d < 4; d++) {
                int x = r + direct[d][0];
                int y = c + direct[d][1];
                if(in(x,y)&& !marked[x][y]){
                    if(dfs(x,y,start+1)){
                        return true;
                    }
                }
            }
            marked[r][c]=false;
        }
        return false;
    }


}
