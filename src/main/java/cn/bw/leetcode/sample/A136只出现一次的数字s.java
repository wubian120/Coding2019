package cn.bw.leetcode.sample;

import java.util.HashMap;
import java.util.List;

/**
 * @ClassName : A136只出现一次的数字s
 * @Description :
 * @Author : Richard.Wu
 * @Date: 2020-02-11 08:38
 */

public class A136只出现一次的数字s {

    // self  it works
    public int singleNumber(int[] nums) {
        int len = nums.length;
        boolean[] checked = new boolean[len];
        HashMap<Integer, Integer> checkMap = new HashMap<>();


        for (int i = 0; i < len; i++) {

            if (checkMap.containsKey(nums[i])) {
                int value = checkMap.get(nums[i]);
                if (value == 1) {
                    checkMap.remove(nums[i]);
                }


            } else {
                checkMap.put(nums[i], 1);
            }
        }

        return checkMap.keySet().stream().findAny().get();
    }


    /// beautiful
    public int singleNumber1(int[] nums) {
        int ans = nums[0];
        if (nums.length > 1) {
            for (int i = 1; i < nums.length; i++) {
                ans = ans ^ nums[i];
            }
        }
        return ans;


    }

}
