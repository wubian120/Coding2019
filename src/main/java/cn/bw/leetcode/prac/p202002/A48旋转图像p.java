package cn.bw.leetcode.prac.p202002;

/**
 * @ClassName : A48旋转图像p
 * @Author : Richard.Wu
 * @Date: 2020-04-06 14:20
 * @Description :
 */

public class A48旋转图像p {


    public void rotate(int[][] matrix) {

       int rows = matrix.length;
       for(int i=0;i<rows;i++){
           for(int col=i;col<rows;col++){
               int t = matrix[i][col];
               matrix[i][col]=matrix[col][i];
               matrix[col][i]=t;
           }
       }

       for(int i=0;i<rows;i++){
           for(int j=0;j<rows/2;j++){
               int t = matrix[i][rows-j-1];
               matrix[i][rows-j-1]=matrix[i][j];
               matrix[i][j]=t;
           }
       }



    }



}
