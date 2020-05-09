package cn.bw.leetcode.prac.p202002;

/**
 * @ClassName : A152乘积最大子序列p1
 * @Description :
 * @Author : Richard.Wu
 * @Date: 2020-02-11 14:27
 * <p>
 * 2020-04-27
 */

public class A152乘积最大子数组p1 {
    public int maxProduct(int[] nums) {

        int tmax=nums[0], tmin=nums[0], max=nums[0];
        int len=nums.length;
        for(int i=1;i<len;i++){

            int pre=tmax;
            tmax = Math.max(tmax*nums[i],Math.max(tmin*nums[i],nums[i]));
            tmin = Math.min(pre*nums[i],Math.min(tmin*nums[i],nums[i]));

            max=Math.max(max,tmax);
        }

        return max;



    }
}
