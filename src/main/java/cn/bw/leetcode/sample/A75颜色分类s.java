package cn.bw.leetcode.sample;

/**
 * @ClassName : A75颜色分类s
 * @Description : leetcode 75 颜色分类
 *
 * 思路：i0 对应0的 右端 位置， i2 对应 2的左端位置。
 * current 对应
 *
 *
 * @Author : Richard.Wu
 * @Date: 2020-01-23 17:11
 */

public class A75颜色分类s {

    public void sortColors(int[] nums) {

        int i0 = 0, i2 = nums.length - 1, current = 0;
        int t=0;
        while (current <= i2) {

            if (nums[current] == 0) {
                t = nums[i0];
                nums[i0]=nums[current];
                nums[current]=t;

                i0++;
                current++;
            } else if (nums[current] == 2) {
                t=nums[current];
                nums[current]=nums[i2];
                nums[i2]=t;

                i2--;
            } else {
                current++;
            }
        }


    }

}
