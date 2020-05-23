package cn.bw.leetcode.prac.p202002;

import java.util.Arrays;

/**
 * @ClassName : A300最长上升子序列p
 * @Author : Richard.Wu
 * @Date: 2020-04-25 11:21
 * @Description :
 */

public class A300最长上升子序列p {


    public int lengthOfLIS(int[] nums) {

        int len=nums.length;
        int[] dp = new int[len];
        dp[0]=0;
        Arrays.fill(dp,1);

        int result=1;
        for(int i=0;i<len;i++){
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }

                result=Math.max(dp[i],result);
            }
        }

        return result;
    }






}
