package cn.bw.leetcode.prac.p202002;

/**
 * @ClassName : A48旋转图像p
 * @Author : Richard.Wu
 * @Date: 2020-04-06 14:20
 * @Description :
 */

public class A48旋转图像p {


    public void rotate(int[][] matrix) {

       int n = matrix.length;
       for(int row=0;row<n;row++){
           for(int col=row;col<n;col++){

               int t = matrix[row][col];
               matrix[row][col]=matrix[col][row];
               matrix[col][row]=t;

           }
       }


       for(int row=0;row<n;row++){
           for(int col=0;col<n/2;col++){

               int t = matrix[row][col];
               matrix[row][col]=matrix[row][n-col-1];
               matrix[row][n-col-1]=t;
           }
       }

    }



}
