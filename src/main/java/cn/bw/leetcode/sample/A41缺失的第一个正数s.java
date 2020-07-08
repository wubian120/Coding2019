package cn.bw.leetcode.sample;

/**
 * @ClassName : A41缺失的第一个正数s
 * @Author : Richard.Wu
 * @Date: 2020-06-27 11:10
 * @Description :
 *
 * 遍历第一遍，如果nums[i]在1-nums.length之间，就放到对应的位置上去，比如2放到nums[1]上，1放到nums[0]上.
 * 遍历第二遍，如果nums[i] != i+1，则返回i+1.遍历完成后如果没有返回，则最后返回nums.length+1
 *
 *
 *
 *
 *
 *
 */

public class A41缺失的第一个正数s {



    public int firstMissingPositive(int[] nums) {
        if(nums == null || nums.length == 0){
            return 1;
        }
        int i = 0;
        while(i < nums.length){
            if(nums[i] == i + 1){
                i++;
                continue;
            }
            if(nums[i] < 1 || nums[i] > nums.length){
                i++;
                continue;
            }
            int k = nums[i];
            if(nums[k-1] == k){
                i++;
                continue;
            }else{
                nums[i] = nums[k-1];
                nums[k-1] = k;
            }
        }
        for(i = 0; i < nums.length; i++){
            if(nums[i] != i+1){
                return i+1;
            }
        }
        return nums.length + 1;

    }







    public int firstMissingPositive1(int[] nums) {
        int length = nums.length;
        int bit[] = new int[(length - 1) / 32 + 1];
        for (int i = 0; i < nums.length; i++) {
            int digit = nums[i];
            //数组必须在1到length之间才有效
            if (digit >= 1 && digit <= length) {
                int index = (digit - 1) / 32;
                bit[index] |= (1 << ((digit - 1) % 32));
            }
        }
        //最后在执行一遍循环，查看对应位置的元素是否正确，如果不正确直接返回
        for (int i = 0; i < nums.length; i++) {
            if ((bit[i / 32] & (1 << (i % 32))) == 0)
                return i + 1;
        }
        return length + 1;
    }


    public static void main(String[] args){

        int[] nums={1,2,0};





    }
}
