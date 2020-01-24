package cn.bw.leetcode.sample;

/**
 * @ClassName : A96不同的二叉搜索树s
 * @Description : leetcode 96 不同的二叉搜索树
 * @Author : Richard.Wu
 * @Date: 2020-01-25 02:08
 */

public class A96不同的二叉搜索树s {


    public int numTrees(int n) {

        if (n == 0) return 0;
        if (n == 1) return 1;

        int[] nums = new int[n + 1];
        nums[0] = 1;
        nums[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                nums[i] = nums[i] + nums[j] * nums[i - 1 - j];
            }
        }
        return nums[n];
    }



}
