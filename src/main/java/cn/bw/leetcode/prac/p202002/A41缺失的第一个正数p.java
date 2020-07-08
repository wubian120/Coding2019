package cn.bw.leetcode.prac.p202002;

/**
 * @ClassName : A41缺失的第一个正数p
 * @Author : Richard.Wu
 * @Date: 2020-06-27 11:12
 * @Description :
 */

public class A41缺失的第一个正数p {

    public int firstMissingPositive(int[] nums) {

        if(nums==null||nums.length==0){
            return 1;
        }
        int len=nums.length;

        int i = 0;
        while (i<len){

            if(nums[i]==i+1){
                i++;
                continue;
            }

            if(nums[i]<1||nums[i]>len){
                i++;
                continue;
            }

            int k =nums[i];
            if(nums[k-1]==k){
                i++;
                continue;
            }else {
                nums[i]=nums[k-1];
                nums[k-1]=k;
            }
        }

        for(i=0;i<len;i++){
            if(nums[i]!=i+1){
                return i+1;
            }
        }

        return len+1;

    }

}
