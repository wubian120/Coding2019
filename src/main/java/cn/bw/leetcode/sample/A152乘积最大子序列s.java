package cn.bw.leetcode.sample;

/**
 * @ClassName : A152乘积最大子序列s
 * @Description :
 * @Author : Richard.Wu
 * @Date: 2020-02-09 11:42
 */

public class A152乘积最大子序列s {
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


    public static void main(String[] args){

        int[] nums={2,3,-2,4};

        A152乘积最大子序列s a = new A152乘积最大子序列s();

        int result = a.maxProduct(nums);

        System.out.println(result);

    }

}
