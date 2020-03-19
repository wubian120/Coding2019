package cn.bw.leetcode.sample;

public class A59螺旋矩阵IIS {
    public int[][] generateMatrix(int n) {



        int left = 0, right = n - 1, top = 0, bottom = n - 1;

        int[][] matrix = new int[n][n];
        int current = 1, total = n * n;
        while (current <= total) {
            //left to right
            for (int i = left; i <= right; i++) {
                matrix[top][i] = current++;
            }
            top++;

            //top to bottom
            for (int i = top; i <= bottom; i++) {
                matrix[i][right] = current++;
            }
            right--;

            //right to left
            for (int i = right; i >= left; i--) {
                matrix[bottom][i] = current++;
            }
            bottom--;
            //bottom to top
            for (int i = bottom; i >= top; i--) {
                matrix[i][left] = current++;
            }
            left++;

        }
        return matrix;


    }

}
