package cn.bw.leetcode.prac.p202002;

/**
 * @ClassName : A240搜索二维矩阵IIp
 * @Author : Richard.Wu
 * @Date: 2020-05-23 14:30
 * @Description :
 */

public class A240搜索二维矩阵IIp {

    public boolean searchMatrix(int[][] matrix, int target) {

        if(matrix==null||matrix.length==0||matrix[0].length==0){
            return false;
        }

        int rows = matrix.length;
        int row=0, col=matrix[0].length-1;

        while (row<rows&&col>=0){

            if(matrix[row][col]>target){
                col--;

            }else if(matrix[row][col]<target){
                row++;
            }else {
                return true;
            }

        }
        return false;



    }




}
