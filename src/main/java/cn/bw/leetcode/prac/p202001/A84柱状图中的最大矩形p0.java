package cn.bw.leetcode.prac.p202001;

import java.util.Stack;

public class A84柱状图中的最大矩形p0 {

    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stacks = new Stack<>();
        int maxArea=0;
        stacks.push(-1);

        for(int i=0;i<heights.length;i++){
            while (stacks.peek()!=-1&&heights[stacks.peek()]>=heights[i]){
                int high=heights[stacks.pop()];
                int width = i-stacks.peek()-1;
                maxArea = Math.max(maxArea,high*width);
            }
            stacks.push(i);
        }

        while (stacks.peek()!=-1){
            maxArea = Math.max(maxArea,heights[stacks.pop()]*(heights.length-stacks.peek()-1));

        }

        return maxArea;

    }
}
