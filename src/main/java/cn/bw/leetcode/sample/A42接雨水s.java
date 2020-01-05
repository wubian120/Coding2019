package cn.bw.leetcode.sample;

public class A42接雨水s {

    public int trap(int[] A){
        int front = 0, end = A.length - 1, max = 0, leftMax = 0, rightMax = 0;

        while (front < end) {

            leftMax = Math.max(A[front], leftMax);
            rightMax = Math.max(A[end], rightMax);

            if (leftMax < rightMax) {
                max += (leftMax - A[front]);
                front++;
            } else {
                max += (rightMax - A[end]);
                end--;
            }

        }

        return max;
    }
}
