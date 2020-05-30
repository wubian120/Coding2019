package cn.bw.leetcode.sample;

/**
 * @ClassName : A238除自身以外数组的乘积s
 * @Author : Richard.Wu
 * @Date: 2020-05-30 12:49
 * @Description :
 */

public class A238除自身以外数组的乘积s {

    public int[] productExceptSelf(int[] nums) {

        int len=nums.length;
        int[] left = new int[len];
        int[] right = new int[len];

        int[] result = new int[len];

        left[0]=1;
        right[len-1]=1;
        for(int i=1;i<len;i++){
            left[i]=nums[i-1] * left[i-1];
        }

        for(int i=len-2;i>=0;i--){
            right[i] = nums[i+1]*right[i+1];
        }

        for(int i=0;i<len;i++){
            result[i]=left[i]*right[i];
        }

        return result;
    }

}
