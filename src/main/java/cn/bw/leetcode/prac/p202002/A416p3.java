package cn.bw.leetcode.prac.p202002;

/**
 * @ClassName : A416p3
 * @Author : Richard.Wu
 * @Date: 2020-02-19 08:52
 * @Description :
 * <p>
 * 2020-02-21  p4
 */

public class A416p3 {

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum & 1) == 1) return false;

        int half = sum / 2;

        boolean[] dp=new boolean[half+1];
        dp[0]=true;

        for(int num:nums){
            for(int i=half;i>=num;i--){
                if(dp[i-num]){
                    dp[i]=true;
                }
            }
        }

        return dp[half];

    }

}
