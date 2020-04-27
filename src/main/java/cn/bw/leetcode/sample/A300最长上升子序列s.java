package cn.bw.leetcode.sample;

import java.util.Arrays;

/**
 * @ClassName : A300最长上升子序列s
 * @Author : Richard.Wu
 * @Date: 2020-04-25 11:13
 * @Description :
 *
 * dp[i]  前i个数字的最长上升子序列长度
 *
 */

public class A300最长上升子序列s {


    /**
     * 基本解法:
     *
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        int res = 0;
        Arrays.fill(dp, 1);
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i])
                    dp[i] = Math.max(dp[i], dp[j] + 1);
            }
            res = Math.max(res, dp[i]);
        }
        return res;
    }


    public static void main(String[] args){

        int[] nums={10,9,2,5,3,7,101,18};



    }


}
