package cn.bw.leetcode.sample;

/**
 * @ClassName : A152乘积最大子序列s
 * @Description :
 * @Author : Richard.Wu
 * @Date: 2020-02-09 11:42
 */

public class A152乘积最大子数组s {
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


    public static void main(String[] args) {

        int[] nums = {2, 3, -2, 4};

        A152乘积最大子数组s a = new A152乘积最大子数组s();

        int result = a.maxProduct(nums);

        System.out.println(result);

    }

}
