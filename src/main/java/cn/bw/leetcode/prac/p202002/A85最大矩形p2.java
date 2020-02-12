package cn.bw.leetcode.prac.p202002;

import java.util.Stack;

/**
 * @ClassName : A85最大矩形p2
 * @Author : Richard.Wu
 * @Date: 2020-02-12 11:22
 * @Description :
 */

public class A85最大矩形p2 {

    public int maximalRectangle(char[][] matrix) {

        int rows = matrix.length;
        if (rows == 0) return 0;
        int cols = matrix[0].length;

        int[] dp = new int[cols];
        int area = 0;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                dp[c] = matrix[r][c] == '1' ? (1 + dp[c]) : 0;
            }
            area = Math.max(area, getArea(dp));
        }


        return area;
    }

    private int getArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int area=0;
        stack.push(-1);
        int len=heights.length;
        for(int i=0;i<len;i++){

            while (stack.peek()!=-1 && heights[stack.peek()]>=heights[i]){
                int h=heights[stack.pop()];
                int w = i-stack.peek()-1;
                area=Math.max(area,w*h);
            }
            stack.push(i);
        }

        while (stack.peek()!=-1){
            int h=heights[stack.pop()];
            int w=len-stack.peek()-1;
            area=Math.max(area,w*h);
        }

        return area;

    }

}
