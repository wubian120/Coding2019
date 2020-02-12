package cn.bw.leetcode.sample;

import java.util.Stack;

public class A85最大矩形s {
    public int maximalRectangle(char[][] matrix) {

        int rows=matrix.length;
        if(rows==0){
            return 0;
        }
        int cols=matrix[0].length;

        int[] heights=new int[cols];
        int area=0;
        for(int r=0;r<rows;r++){
            for(int c=0;c<cols;c++){
                heights[c]=matrix[r][c]=='1'?1+heights[c]:0;

            }
            area=Math.max(area,getArea(heights));
        }

        return area;
    }

    private int getArea(int[] heights){
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int area=0;
        int len=heights.length;
        for(int i=0;i<len;i++){

            while (stack.peek()!=-1 && (heights[stack.peek()]>=heights[i])){

                int h=heights[stack.pop()];
                int w = i-stack.peek()-1;
                area = Math.max(area,h*w);

            }

            stack.push(i);
        }

        while (stack.peek()!=-1){
            area = Math.max(heights[stack.pop()]*(len-stack.peek()-1),area);
        }
        return area;

    }

    public static void main(String... args) {

        char[][] matrix = {{'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}};

        A85最大矩形s a = new A85最大矩形s();

        int result = a.maximalRectangle(matrix);


    }


}
