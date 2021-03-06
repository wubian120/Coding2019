package cn.bw.leetcode.prac.p202002;

import java.util.Stack;

/**
 * @ClassName : A84柱状图中的最大矩形p0
 * @Description :
 * @Author : Richard.Wu
 * @Date: 2020-02-08 18:01
 */

public class A84柱状图中的最大矩形p0 {

    public int largestRectangleArea(int[] heights) {

        int len = heights.length;

        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxArea = 0;
        for (int i = 0; i < len; i++) {
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i]) {
                int h = heights[stack.pop()];
                int w = i - stack.peek() - 1;

                maxArea = Math.max(maxArea, w * h);
            }
            stack.push(i);
        }

        while (stack.peek() != -1) {
            int h = heights[stack.pop()];
            int w = len - stack.peek() - 1;
            maxArea = Math.max(maxArea, w * h);
        }

        return maxArea;
    }

}
