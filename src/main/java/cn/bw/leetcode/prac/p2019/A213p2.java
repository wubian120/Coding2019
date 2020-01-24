package cn.bw.leetcode.prac.p2019;

public class A213p2 {

    public int rob(int[] nums) {

        if(nums==null || nums.length==0){
            return 0;
        }
        int len=nums.length;
        if(len==1){
            return nums[0];
        }
        if(len==2){
            return Math.max(nums[0],nums[1]);
        }
        return Math.max(rob(0,len-2,nums),
                rob(1,len-1,nums));

    }

    private int rob(int start,int end, int[] nums){

        int len=nums.length;
        int[] dp=new int[len];
        dp[start]=nums[start];
        dp[start+1]=Math.max(nums[start],nums[start+1]);
        for(int i=start+2;i<=end;i++){
            dp[i]=Math.max(dp[i-2]+nums[i],dp[i-1]);
        }
        return dp[end];

    }

}
