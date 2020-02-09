package cn.bw.leetcode.sample;

import java.util.Arrays;

/**
 * @ClassName : A416分割等合子集s
 * @Description :
 *
 *  dp[i]表示 能否找到 和 为i的 数组元素集合。
 *
 *
 * @Author : Richard.Wu
 * @Date: 2020-02-06 19:32
 */

public class A416分割等合子集s {

    public boolean canPartition(int[] nums) {
        int sum=0;
        for(int i:nums){
            sum +=i;
        }

        if(sum%2 ==1){
            return false;
        }

        int half=sum/2;

        //dp[i] nums数组 能够组成 和为i的 状态。
        boolean[] dp=new boolean[half+1];
        dp[0]=true;

        for(int num:nums){
            for(int i=half;i>=num;i--){
                //dp[i-num] 表示 可以找到 和为 i-num的集合
                if(dp[i-num]){
                    dp[i]=true;
                }
            }
        }
        return  dp[half];

    }

    public static void main(String...args){

        int[] nums = {1,5,11,5};

        A416分割等合子集s a = new A416分割等合子集s();

        boolean result = a.canPartition(nums);

        System.out.println(result);
        System.out.println("end");


    }

}
