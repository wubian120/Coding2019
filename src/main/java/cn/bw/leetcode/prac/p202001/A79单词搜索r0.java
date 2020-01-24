package cn.bw.leetcode.prac.p202001;

/**
 * @ClassName : A79单词搜索r0
 * @Description : leetcode 79单词搜索
 * @Author : Richard.Wu
 * @Date: 2020-01-23 23:12
 */

public class A79单词搜索r0 {

    private boolean[][] marked;
    //      x-1,y
    //x,y-1, x,y  x,y+1
    //      x+1,y
    private int[][] direct = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    int rows, cols;

    private boolean in(int x, int y) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }

    public boolean exist(char[][] board, String word) {
        rows = board.length;
        if (rows == 0) {
            return false;
        }
        cols = board[0].length;
        marked = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (dfs(i, j, 0, word, board)) {
                    return true;
                }
            }
        }

        return false;

    }

    private boolean dfs(int i, int j, int start, String word, char[][] board) {
        if (start == word.length() - 1) {
            return board[i][j] == word.charAt(start);
        }

        if (board[i][j] == word.charAt(start)) {
            marked[i][j] = true;
            for (int k = 0; k < direct.length; k++) {
                int newX = i + direct[k][0];
                int newY = j + direct[k][1];
                boolean isIn = in(newX, newY);
                if (in(newX, newY) && !marked[newX][newY]) {
                    if (dfs(newX, newY, start + 1, word, board)) {
                        return true;
                    }
                }
            }
            marked[i][j] = false;
        }
        return false;
    }

    public static void main(String[] args) {

        char[][] board =
                {
                        {'A', 'B', 'C', 'E'},
                        {'S', 'F', 'C', 'S'},
                        {'A', 'D', 'E', 'E'}
                };
//
        String word = "ABCCED";


        A79单词搜索r0 a = new A79单词搜索r0();


        boolean result = a.exist(board, word);

        System.out.println(result);


    }
}
