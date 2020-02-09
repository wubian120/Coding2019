package cn.bw.leetcode.sample;

/**
 * @ClassName : A152乘积最大子序列s
 * @Description :
 * @Author : Richard.Wu
 * @Date: 2020-02-09 11:42
 */

public class A152乘积最大子序列s {
    public int maxProduct(int[] nums) {
        int n = nums.length;


        int dpMax = nums[0];
        int dpMin = nums[0];
        int max = nums[0];
        for (int i = 1; i < n; i++) {
            //更新 dpMin 的时候需要 dpMax 之前的信息，所以先保存起来
            int preMax = dpMax;
            dpMax = Math.max(dpMin * nums[i], Math.max(dpMax * nums[i], nums[i]));
            dpMin = Math.min(dpMin * nums[i], Math.min(preMax * nums[i], nums[i]));
            max = Math.max(max, dpMax);
        }
        return max;
    }

}
