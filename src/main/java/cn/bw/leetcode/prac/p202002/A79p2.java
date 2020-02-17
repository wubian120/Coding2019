package cn.bw.leetcode.prac.p202002;

/**
 * @ClassName : A79p2
 * @Author : Richard.Wu
 * @Date: 2020-02-17 14:26
 * @Description :
 */

public class A79p2 {


    int[][] direct = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    int rows = 0, cols = 0;
    String word;
    char[][] board;
    boolean[][] marked;

    public boolean exist(char[][] board, String word) {

        rows = board.length;
        if (rows == 0) return false;
        cols = board[0].length;

        this.board = board;
        this.word = word;

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

    private boolean in(int x, int y) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }

    private boolean dfs(int r, int c, int start) {

        if (start == word.length() - 1) {
            return board[r][c] == word.charAt(start);
        }

        if (board[r][c] == word.charAt(start)) {

            marked[r][c] = true;
            for (int i = 0; i < direct.length; i++) {
                int x = r + direct[i][0];
                int y = c + direct[i][1];
                if (in(x, y) && !marked[x][y]) {
                    if (dfs(x, y, start + 1)) {
                        return true;
                    }
                }
            }
            marked[r][c] = false;
        }

        return false;

    }

}
