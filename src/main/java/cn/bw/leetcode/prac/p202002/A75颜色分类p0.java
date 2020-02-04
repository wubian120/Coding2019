package cn.bw.leetcode.prac.p202002;

/**
 * @ClassName : A75颜色分类p0
 * @Description :
 * @Author : Richard.Wu
 * @Date: 2020-02-05 00:25
 */

public class A75颜色分类p0 {

    public void sortColors(int[] nums) {

        int i0=0, i2=nums.length-1;

        int current=0;
        int temp=0;
        while (current<=i2){

            if(nums[current]==0){
                temp=nums[i0];
                nums[i0]=nums[current];
                nums[current]=temp;

                i0++;
                current++;
            }else if(nums[current]==2){
                temp=nums[current];
                nums[current]=nums[i2];
                nums[i2]=temp;

                i2--;
            }else {
                current++;
            }
        }

    }

}
