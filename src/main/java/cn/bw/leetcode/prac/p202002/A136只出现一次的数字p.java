package cn.bw.leetcode.prac.p202002;

/**
 * @ClassName : A136只出现一次的数字p
 * @Author : Richard.Wu
 * @Date: 2020-04-24 22:47
 * @Description :
 */

public class A136只出现一次的数字p {


    public int singleNumber(int[] nums) {

        if (nums == null || nums.length == 0) {
            return 0;
        }
        int result = nums[0];

        for(int i=1;i<nums.length;i++){
            result ^=nums[i];
        }

        return result;
    }
}
