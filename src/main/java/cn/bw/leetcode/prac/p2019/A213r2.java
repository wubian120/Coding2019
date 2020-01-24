package cn.bw.leetcode.prac.p2019;

public class A213r2 {

    public int rob(int[] nums){

        if(nums==null ||nums.length==0){
            return 0;
        }
        if(nums.length==1){
            return nums[0];
        }
        if(nums.length==2){
            return Math.max(nums[0],nums[1]);
        }
        int len = nums.length;
        return Math.max(rob(nums,0,len-2),rob(nums,1,len-1));

    }

    private int rob(int[] nums,int start,int end){
        int len = nums.length;
        int[] dp = new int[len];
        dp[start]=nums[start];
        dp[start+1] = Math.max(nums[start],nums[start+1]);
        for(int i=start+2;i<=end;i++){
            dp[i]=Math.max(dp[i-2]+nums[i],dp[i-1]);
        }
        return dp[end];
    }
}
