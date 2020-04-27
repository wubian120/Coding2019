package cn.bw.leetcode.sample;

/**
 * @ClassName : A11cheng1
 * @Author : Richard.Wu
 * @Date: 2020-04-18 08:45
 * @Description :
 *
 * 思路： 双指针
 *
 *
 *
 *
 */

public class A11盛最多水的容器s {

    public int maxArea(int[] height) {


        int right =height.length-1, left = 0;
        int maxArea = 0;

        while(left<right){

            int w = right-left;
            int h = 0;
            if(height[left]<height[right]){
                h=height[left];
                left++;
            }else{
                h=height[right];
                right--;
            }

            maxArea = Math.max(maxArea, w*h);
        }

        return maxArea;


    }


}
