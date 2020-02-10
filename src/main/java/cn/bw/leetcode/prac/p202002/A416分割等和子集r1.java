package cn.bw.leetcode.prac.p202002;

/**
 * @ClassName : A416分割等和子集r1
 * @Description :
 * @Author : Richard.Wu
 * @Date: 2020-02-10 10:08
 */

public class A416分割等和子集r1 {


    ///
    public boolean canPartition0(int[] nums) {

        int sum = 0;
        for (int i : nums) {
            sum += i;
        }

        if ((sum & 1) == 1) {
            return false;
        }

        int half = sum / 2;

        boolean[] dp = new boolean[half+1];

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
