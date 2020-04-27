package cn.bw.leetcode.prac.p202002;

/**
 * @ClassName : A152乘积最大子序列p1
 * @Description :
 * @Author : Richard.Wu
 * @Date: 2020-02-11 14:27
 * <p>
 * 2020-04-27
 */

public class A152乘积最大子序列p1 {
    public int maxProduct(int[] nums) {

        int len = nums.length;
        int max = nums[0], curMax = nums[0], curMin = nums[0];

        for (int i = 1; i < len; i++) {
            int pre = curMax;

            curMax = Math.max(nums[i],
                    Math.max(nums[i] * curMax,
                            nums[i] * curMin));
            curMin = Math.min(nums[i],Math.min(curMin*nums[i],
                    pre*nums[i]));

            max=Math.max(curMax,max);
        }

        return max;

    }
}
