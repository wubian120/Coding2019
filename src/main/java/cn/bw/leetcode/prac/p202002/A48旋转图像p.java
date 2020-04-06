package cn.bw.leetcode.prac.p202002;

/**
 * @ClassName : A48旋转图像p
 * @Author : Richard.Wu
 * @Date: 2020-04-06 14:20
 * @Description :
 */

public class A48旋转图像p {


    public void rotate(int[][] matrix) {

        int row = matrix.length;

        for(int i=0;i<row;i++){
            for(int j=i;j<row;j++){

                int t = matrix[j][i];
                matrix[j][i]=matrix[i][j];
                matrix[i][j]=t;

            }
        }

        for(int i=0;i<row;i++){
            for(int j=0;j<row/2;j++){
                int t = matrix[i][j];
                matrix[i][j]=matrix[i][row-j-1];
                matrix[i][row-j-1]=t;

            }
        }

    }



}
