package cn.bw.leetcode.prac.p202001;

import java.util.Stack;

public class A85最大矩形r0 {

    public int maximalRectangle(char[][] matrix) {

        if(matrix.length==0){
            return 0;
        }
        int maxArea = 0;
        int[] dp = new int[matrix[0].length];

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                dp[j]=matrix[i][j]=='1'? dp[j]+1:0;
            }
            maxArea=Math.max(maxArea,getMaxArea(dp));
        }
        return maxArea;
    }

    private int getMaxArea(int[] heights){
        if(heights==null||heights.length==0) return 0;

        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int len=heights.length;
        int maxArea=0;
        for(int i=0;i<len;i++){

            while (stack.peek()!=-1&& heights[stack.peek()]>=heights[i]){
                maxArea = Math.max(maxArea,(heights[stack.pop()]* (i-stack.peek()-1)));
            }
            stack.push(i);

        }

        while (stack.peek()!=-1){
            maxArea = Math.max(maxArea,(heights[stack.pop()]*(len-stack.peek()-1)));
        }
        return maxArea;
    }

}
