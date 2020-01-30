package cn.bw.leetcode.sample;

/**
 * @ClassName : A79单词搜索r
 * @Description :
 * @Author : Richard.Wu
 * @Date: 2020-01-30 11:34
 */

public class A79单词搜索r {

    //      x-1,y
    //x,y-1  x,y    x,y+1
    //      x+1,y
    int[][] direct = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    boolean[][] marked;
    int rows, cols;
    String word;
    char[][] board;

    public boolean exist(char[][] board, String word) {

        this.rows=board.length;
        if(rows==0){
            return false;
        }
        this.cols=board[0].length;
        this.word=word;
        this.board=board;
        marked=new boolean[rows][cols];

        for(int r=0;r<rows;r++){

            for(int c=0;c<cols;c++){
                if(dfs(r,c,0)){
                    return true;
                }

            }
        }
        return false;


    }

    private boolean in(int x, int y) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }

    private boolean dfs(int r,int c, int start){
        if(start==word.length()-1){
            return board[r][c]==word.charAt(start);
        }

        if(board[r][c]==word.charAt(start)){
            marked[r][c]=true;
            for(int d=0;d<4;d++){
                int newX= r+direct[d][0];
                int newY= c+direct[d][1];
                if(in(newX,newY) && !marked[newX][newY]){
                    if(dfs(newX,newY,start+1)){
                        return true;
                    }
                }
            }
            marked[r][c]=false;
        }
        return false;

    }


}
