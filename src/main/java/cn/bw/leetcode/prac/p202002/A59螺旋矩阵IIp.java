package cn.bw.leetcode.prac.p202002;

/**
 * @ClassName : A59螺旋矩阵p
 * @Author : Richard.Wu
 * @Date: 2020-03-18 16:47
 * @Description :
 * leetcode 59 螺旋矩阵
 * https://leetcode-cn.com/problems/spiral-matrix-ii/
 * <p>
 * prac:
 * 2020-03-18
 */

public class A59螺旋矩阵IIp {

    public int[][] generateMatrix(int n) {

        int left = 0, right = n - 1;
        int top = 0, bottom = n - 1;

        int[][] matrix = new int[n][n];
        int cur = 1, total = n * n;

        while (cur <= total) {

            for (int i = left; i <= right; i++) {
                matrix[top][i]=cur++;
            }
            top++;

            for(int i=top;i<=bottom;i++){
                matrix[i][right]=cur++;
            }
            right--;

            for(int i=right;i>=left;i--){
                matrix[bottom][i]=cur++;
            }
            bottom--;

            for(int i=bottom;i>=top;i--){
                matrix[i][left]=cur++;
            }
            left++;

        }

        return matrix;

    }

}
