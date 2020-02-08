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
        //转化为经典的01背包问题
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        //和的余 为1， 和为奇数
        if (sum % 2 == 1)
            return false;

        int target = sum / 2;

        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        //dp[i]表示能否找到和为i的数组元素集合
        for (int num : nums) {
            for (int i = target; i >= num; i--) {
                if (dp[i - num] == true)
                    dp[i] = true;
            }
        }
        return dp[target];
    }

    public static void main(String...args){

        int[] nums = {1,5,11,5};

        A416分割等合子集s a = new A416分割等合子集s();

        boolean result = a.canPartition(nums);

        System.out.println(result);
        System.out.println("end");


    }

}
