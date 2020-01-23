package cn.bw.leetcode.prac.p202001;

/**
 * @ClassName : A75颜色分类p0
 * @Description :
 * @Author : Richard.Wu
 * @Date: 2020-01-23 17:12
 */

public class A75颜色分类p0 {

    public void sortColors(int[] nums) {
        int idx0 = 0, idx2 = nums.length - 1;
        int current = 0, temp=0;

        while (current <= idx2) {

            if (nums[current] == 0) {
                temp = nums[idx0];
                nums[idx0] = nums[current] ;
                nums[current] = temp;

                current++;
                idx0++;
            } else if (nums[current] == 2) {
                temp = nums[idx2];
                nums[idx2] = nums[current];
                nums[current] = temp;

                idx2--;
            } else {
                current++;
            }
        }

    }


    public static void main(String...args){

        int[] nums = {2};

        A75颜色分类p0 a = new A75颜色分类p0();

        a.sortColors(nums);

    }

}
