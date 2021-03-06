package cn.bw.leetcode.prac.p2019;

public class A198打家劫舍p {

    public int rob(int[] nums) {

        if(nums==null || nums.length==0){
            return 0;
        }
        int len = nums.length;
        if(len==1){
            return nums[0];
        }

        if(len==2){
            return Math.max(nums[0],nums[1]);
        }
        int[] dp = new int[len];
        dp[0]=nums[0];
        dp[1]= Math.max(nums[0],nums[1]);
        for(int i=2;i<len;i++){
            dp[i]=Math.max(dp[i-2]+nums[i],dp[i-1]);
        }

        return dp[len-1];


    }


}
