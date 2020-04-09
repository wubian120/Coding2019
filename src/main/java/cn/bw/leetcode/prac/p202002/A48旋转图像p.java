package cn.bw.leetcode.prac.p202002;

/**
 * @ClassName : A48旋转图像p
 * @Author : Richard.Wu
 * @Date: 2020-04-06 14:20
 * @Description :
 */

public class A48旋转图像p {


    public void rotate(int[][] matrix) {

        int len=matrix.length;

        for(int i=0;i<len;i++){
            for(int j=i;j<len;j++){
                int t = matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=t;
            }
        }


        for(int i=0;i<len;i++){
            for(int j=0;j<len/2;j++){

                int t = matrix[i][j];
                matrix[i][j]=matrix[i][len-j-1];
                matrix[i][len-j-1]=t;
            }
        }



    }



}
