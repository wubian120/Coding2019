package cn.bw.leetcode.sample;

public class A53最大子序和s {

    public int maxSubArray(int[] nums) {
        int sum, current;
        sum = current = nums[0];
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            if (current > 0) {
                current += nums[i];
            } else {
                current = nums[i];
            }
            if (current > sum) {
                sum = current;
            }
        }
        return sum;

    }


}
