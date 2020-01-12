package cn.bw.leetcode.prac.p202001;

public class A42接雨水p {

    public int trap(int[] height) {

        int start = 0, end = height.length - 1;
        int left = 0, right = 0;
        int result = 0;
        while (start < end) {

            left = Math.max(left, height[start]);
            right = Math.max(right, height[end]);
            if (left < right) {
                result += (left - height[start]);
                start++;
            } else {
                result += (right - height[end]);
                end--;
            }
        }

        return result;

    }
}
