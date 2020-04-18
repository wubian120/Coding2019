package cn.bw.leetcode.sample;

/**
 * @ClassName : A11cheng1
 * @Author : Richard.Wu
 * @Date: 2020-04-18 08:45
 * @Description :
 */

public class A11盛最多水的容器s {

    public int maxArea(int[] height) {
        int head = 0, tail = height.length-1;
        int maxArea = 0;
        while (head < tail) {
            int w = tail - head;
            int h, area;
            if(height[tail] < height[head]) {
                h = height[tail];
                tail = tail - 1;
            } else {
                h = height[head];
                head = head + 1;
            }
            area = w * h;
            if ( area> maxArea) {
                maxArea = area;
            }
        }
        return maxArea;
    }


}
