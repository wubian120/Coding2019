package cn.bw.leetcode.prac.p202002;

/**
 * @ClassName : A169多数元素p
 * @Author : Richard.Wu
 * @Date: 2020-04-19 16:28
 * @Description :
 * <p>
 * 2020-04-19
 * 2020-04-24
 */

public class A169多数元素p {


    public int majorityElement(int[] nums) {

        int count = 0, result = nums[0], maxLen = nums.length / 2;
        for(int i:nums){
            if(i==result){
                count++;
                if(count>maxLen){
                    break;
                }
            }else {
                count--;
                if(count==0){
                    result=i;
                    count=1;
                }
            }
        }

        return result;

    }

}
