package cn.bw.leetcode.prac.p202002;

/**
 * @ClassName : A53最大子序列和p0
 * @Author : Richard.Wu
 * @Date: 2020-02-18 22:41
 * @Description :
 */

public class A53最大子序列和p0 {

    public int maxSubArray(int[] nums) {

        int sum=nums[0], cur=nums[0];
        int len=nums.length;
        for(int i=1;i<len;i++){

            if(cur>=0){
                cur+=nums[i];
            }else {
                cur=nums[i];
            }
            sum=Math.max(sum,cur);
        }

        return sum;

    }


    public static void main(String...args){

        int[] nums={1};
        A53最大子序列和p0 a=new A53最大子序列和p0();

        int result=a.maxSubArray(nums);

    }
}
