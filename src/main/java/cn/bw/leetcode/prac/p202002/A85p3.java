package cn.bw.leetcode.prac.p202002;

import java.util.Stack;

/**
 * @ClassName : A85p3
 * @Author : Richard.Wu
 * @Date: 2020-02-15 15:14
 * @Description :
 */

public class A85p3 {

    public int maximalRectangle(char[][] matrix) {
        int rows = matrix.length;
        if (rows == 0) {
            return 0;
        }
        int cols = matrix[0].length;
        int area = 0;
        int[] heights = new int[cols];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                heights[c] = matrix[r][c] == '1' ? heights[c] + 1 : 0;
            }
            area = Math.max(area, getArea(heights));
        }
        return area;
    }

    private int getArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int len = heights.length;
        int area = 0;
        for (int i = 0; i < len; i++) {

            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {

                int h = heights[stack.pop()];
                int w = i - stack.peek()- 1;
                area = Math.max(area, w * h);
            }
            stack.push(i);
        }

        while (stack.peek() != -1) {
            int h = heights[stack.pop()];
            int w = len - stack.peek() - 1;
            area = Math.max(area, w * h);
        }

        return area;

    }


}
