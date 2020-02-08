package cn.bw.leetcode.prac.p202002;

/**
 * @ClassName : A416分割等和子集r0
 * @Description :
 * @Author : Richard.Wu
 * @Date: 2020-02-08 13:21
 */

public class A416分割等和子集r0 {

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
        boolean[] dp=new boolean[half];
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
}
