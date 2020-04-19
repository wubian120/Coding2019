package cn.bw.leetcode.sample;

/**
 * @ClassName : A169多数元素s
 * @Author : Richard.Wu
 * @Date: 2020-04-19 15:56
 * @Description :
 * 思路 ：
 * Boyer-Moore 投票算法
 *
 */

public class A169多数元素s {

    public int majorityElement(int[] nums) {
        int count = 0, res = nums[0], maxLen = nums.length / 2;
        for (int number : nums) {
            if (number == res) {
                count++;
                if (count > maxLen) {
                    return res;
                }
            } else {
                count--;
                if (count == 0) {
                    res = number;
                    count = 1;
                }
            }
        }
        return res;
    }

}
