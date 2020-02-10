package cn.bw.leetcode.prac.p202002;

/**
 * @ClassName : A152p0
 * @Description :
 * @Author : Richard.Wu
 * @Date: 2020-02-10 12:13
 */

public class A152p0 {

    public int maxProduct(int[] nums) {

        int len = nums.length;
        int tmax = nums[0], tmin = nums[0], max = nums[0];

        for (int i = 1; i < len; i++) {
            int pre = tmax;

            tmax = Math.max(tmax * nums[i], Math.max(tmin * nums[i], nums[i]));
            tmin = Math.min(pre * nums[i], Math.min(tmin * nums[i], nums[i]));

            max = Math.max(tmax, max);
        }

        return max;

    }


}
