package cn.bw.leetcode.prac.p202002;

/**
 * @ClassName : A416分割等合子集p0
 * @Description :
 * @Author : Richard.Wu
 * @Date: 2020-02-11 10:51
 */

public class A416分割等合子集p0 {

    public boolean canPartition(int[] nums) {
        int len = nums.length;
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }

        if ((sum & 1) == 1) {
            return false;
        }

        int half = sum / 2;

        boolean[][] dp = new boolean[len][half + 1];

        if(nums[0]<=half){
            dp[0][0]=true;
        }

        for (int i =1; i < len; i++) {
            for (int j = 0; j <= half; j++) {
                if(nums[i]==j){
                    dp[i][j]=true;
                    continue;
                }else if(nums[i]<j){
                    dp[i][j]=dp[i-1][j]||dp[i-1][j-nums[i]];
                }
            }

        }

        return dp[len-1][half];
    }


    public boolean canPartition1(int[] nums) {

        

    }

}
