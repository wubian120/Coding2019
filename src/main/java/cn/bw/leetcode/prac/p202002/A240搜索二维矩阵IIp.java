package cn.bw.leetcode.prac.p202002;

/**
 * @ClassName : A240搜索二维矩阵IIp
 * @Author : Richard.Wu
 * @Date: 2020-05-23 14:30
 * @Description :
 */

public class A240搜索二维矩阵IIp {

    public boolean searchMatrix(int[][] matrix, int target) {

        if(matrix==null||matrix.length==0){
            return false;
        }

        int shorter = Math.min(matrix.length, matrix[0].length);

        for(int i=0;i<shorter;i++){
            boolean vertical=binarySearch(matrix,target,i,true);
            boolean horizon = binarySearch(matrix,target,i,false);

            if(vertical||horizon){
                return true;
            }
        }
        return false;

    }

    private boolean binarySearch(int[][] matrix,
                                 int target,
                                 int start,
                                 boolean isVertical) {

        int low = start;
        int high = isVertical ? matrix[0].length - 1 : matrix.length - 1;

        while (high>=low){
            int mid = (low+high)/2;
            if(isVertical){
                //列
                if(matrix[start][mid]<target){
                    low=mid+1;
                }else if(matrix[start][mid]>target){
                    high=mid-1;
                }else {
                    return true;
                }
            }else {
                //行
                if(matrix[mid][start]<target){
                    low=mid+1;
                }else if(matrix[mid][start]>target){
                    high=mid-1;
                }else {
                    return true;
                }
            }
        }
        return false;
    }


}
