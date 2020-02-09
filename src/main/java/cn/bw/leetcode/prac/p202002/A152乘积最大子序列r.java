package cn.bw.leetcode.prac.p202002;

/**
 * @ClassName : A152乘积最大子序列r
 * @Description :
 * @Author : Richard.Wu
 * @Date: 2020-02-09 11:55
 */

public class A152乘积最大子序列r {

    public int maxProduct(int[] nums) {
        int len = nums.length;
        int tmax = nums[0];
        int tmin = nums[0];
        int max = nums[0];

        for (int i = 1; i < len; i++) {

            int pre = tmax;
            tmax = Math.max(tmin * nums[i], Math.max(tmax * nums[i], nums[i]));
            tmin = Math.min(tmin * nums[i], Math.min(pre * nums[i], nums[i]));
            max = Math.max(max, tmax);
        }

        return max;

    }

}
