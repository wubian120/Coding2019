package cn.bw.leetcode.sample;

import java.util.Stack;

public class A84柱状图中的最大矩形s {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxArea=0;
        for(int i=0;i<heights.length;i++){

            while(stack.peek()!=-1&& heights[stack.peek()] >=heights[i]){
                int high=heights[stack.pop()];
                int width= i-stack.peek()-1;
                maxArea = Math.max(maxArea,high*width);
            }
            stack.push(i);
        }

        while (stack.peek() !=-1){
            maxArea = Math.max(maxArea,heights[stack.pop()] *(heights.length-stack.peek()-1));
        }

        return maxArea;
    }


}
