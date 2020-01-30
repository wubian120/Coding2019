package cn.bw.leetcode.prac.p202001;

import cn.bw.leetcode.sample.A85最大矩形s;

import java.util.Stack;

/**
 * @ClassName : A85最大矩形p1
 * @Description :
 * @Author : Richard.Wu
 * @Date: 2020-01-29 23:37
 */

public class A85最大矩形p1 {

    public int maximalRectangle(char[][] matrix) {

        int rows = matrix.length;
        if (rows == 0) return 0;
        int cols = matrix[0].length;
        int[] dp = new int[cols];
        int maxArea = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {


//                dp[c] = matrix[r][c] == '1' ? dp[c] + 1 : 0;
                if (matrix[r][c] == '1') {
                    dp[c] += 1;
                } else {
                    dp[c] = 0;
                }
            }
            maxArea = Math.max(maxArea, getArea(dp));
        }


        return maxArea;
    }


    public int getArea(int[] heights) {

        int len = heights.length, area = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < len; i++) {
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {
                area = Math.max(area, (heights[stack.pop()] * (i - stack.peek() - 1)));
            }
            stack.push(i);
        }

        while (stack.peek() != -1) {
            area = Math.max(area, heights[stack.pop()]*(len-stack.peek()-1));
        }


        return area;

    }

    public static void main(String... args) {

        char[][] matrix = {{'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}};

        A85最大矩形p1 a = new A85最大矩形p1();

        int result = a.maximalRectangle(matrix);


    }


}
