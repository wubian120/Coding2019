package cn.bw.leetcode.prac.p202001;

/**
 * @ClassName : A75颜色分类r0
 * @Description :
 * @Author : Richard.Wu
 * @Date: 2020-01-29 14:03
 */



public class A75颜色分类r0 {
    public void sortColors(int[] nums) {

        int i0=0, i2=nums.length-1, current=0;
        int temp=0;

        while (current<=i2){
            if(nums[current]==0){
                temp=nums[current];
                nums[current]=nums[i0];
                nums[i0]=temp;

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
