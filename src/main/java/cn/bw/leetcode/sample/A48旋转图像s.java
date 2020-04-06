package cn.bw.leetcode.sample;

/**
 * @ClassName : A48旋转图像s
 * @Author : Richard.Wu
 * @Date: 2020-04-06 14:12
 * @Description :
 */

public class A48旋转图像s {

    public void rotate(int[][] matrix) {
        int n = matrix.length;

        // 转置， i,j  和 j,i 交换
        // 为啥 j=i 开始，相当于 对角线 开始，
        // 对角线上半部分
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int tmp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = tmp;
            }
        }
        // 左右 翻转 每一行
        //j < n/2 对角线下半部分
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = tmp;
            }
        }
    }


    public static void main(String[] args){

        int[][] matrix={{1,2,3},{4,5,6},{7,8,9}};

        A48旋转图像s a = new A48旋转图像s();

        a.rotate(matrix);



    }


}
