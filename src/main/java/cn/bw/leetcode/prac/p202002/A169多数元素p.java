package cn.bw.leetcode.prac.p202002;

/**
 * @ClassName : A169多数元素p
 * @Author : Richard.Wu
 * @Date: 2020-04-19 16:28
 * @Description :
 *
 * 2020-04-19
 * 2020-04-24
 *
 */

public class A169多数元素p {


    public int majorityElement(int[] nums) {

        int count = 0, result=nums[0], maxLen=nums.length/2;

        for(int number:nums){

            if(number==result){
                count++;
                if(count>maxLen){
                    return result;
                }
            }else {
                count--;
                if(count==0){
                    result=number;
                    count=1;
                }
            }

        }

        return result;


    }

}
