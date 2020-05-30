package cn.bw.leetcode.sample;

/**
 * @ClassName : A283移动零s
 * @Author : Richard.Wu
 * @Date: 2020-05-30 12:13
 * @Description :
 *
 *
 */

public class A283移动零s {

    /**
     * 记录所有非0的值 以及 索引， 后面的全部置为零
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int idx=0;

        for(int num:nums){
            if(num!=0){
                nums[idx++]=num;
            }
        }

        while (idx<nums.length){
            nums[idx++]=0;
        }

    }


}
