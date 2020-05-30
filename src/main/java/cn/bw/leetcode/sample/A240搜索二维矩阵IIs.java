package cn.bw.leetcode.sample;

/**
 * @ClassName : A240搜索二维矩阵IIs
 * @Author : Richard.Wu
 * @Date: 2020-05-23 14:13
 * @Description :
 */

public class A240搜索二维矩阵IIs {



    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length-1;
        int col = 0;

        //边界
        while (row>=0 && col<matrix[0].length){
            if(matrix[row][col]>target){
                row--;
            }else if(matrix[row][col]<target){
                col++;
            }else {
                return true;
            }
        }
        return false;
    }

    private boolean binarySearch(int[][] matrix, int target, int start, boolean vertical) {
        int lo = start;
        int hi = vertical ? matrix[0].length-1 : matrix.length-1;

        while (hi >= lo) {
            int mid = (lo + hi)/2;
            if (vertical) { // searching a column
                if (matrix[start][mid] < target) {
                    lo = mid + 1;
                } else if (matrix[start][mid] > target) {
                    hi = mid - 1;
                } else {
                    return true;
                }
            } else { // searching a row
                if (matrix[mid][start] < target) {
                    lo = mid + 1;
                } else if (matrix[mid][start] > target) {
                    hi = mid - 1;
                } else {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean searchMatrix1(int[][] matrix, int target) {
        // an empty matrix obviously does not contain `target`
        if (matrix == null || matrix.length == 0) {
            return false;
        }

        // iterate over matrix diagonals
        int shorterDim = Math.min(matrix.length, matrix[0].length);
        for (int i = 0; i < shorterDim; i++) {
            boolean verticalFound = binarySearch(matrix, target, i, true);
            boolean horizontalFound = binarySearch(matrix, target, i, false);
            if (verticalFound || horizontalFound) {
                return true;
            }
        }

        return false;
    }


    public static void main(String[] args){

        int[][] matrix = {
                {1,4,7,11,15},
                {2,5,8,12,19},
                {3,6,9,16,22},
                {10,13,14,17,24},
//                {18,21,23,26,30}
        };

        A240搜索二维矩阵IIs  a = new A240搜索二维矩阵IIs();

        int target = 24;

        boolean result = a.searchMatrix(matrix,target);

        System.out.println(result);
    }



}
