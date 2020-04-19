package cn.bw.leetcode.prac.p202002;

/**
 * @ClassName : A11盛最多水的容器p
 * @Author : Richard.Wu
 * @Date: 2020-04-19 10:58
 * @Description :
 */

public class A11盛最多水的容器p {


    public int maxArea(int[] height) {

        int left = 0, right = height.length - 1;

        int maxArea = 0;
        while (left < right) {

            int w = right-left;
            int h, cur;

            if(height[left]<height[right]){
                h=height[left];

                left++;
            }else {
                h=height[right];
                right--;
            }

            cur = w*h;
            maxArea=Math.max(cur,maxArea);

        }

        return maxArea;

    }
}
