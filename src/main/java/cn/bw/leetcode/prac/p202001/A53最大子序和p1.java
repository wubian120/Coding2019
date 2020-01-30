package cn.bw.leetcode.prac.p202001;

/**
 * @ClassName : A53最大子序和p1
 * @Description :
 * @Author : Richard.Wu
 * @Date: 2020-01-30 11:14
 */

public class A53最大子序和p1 {

    public int maxSubArray(int[] nums) {

        int current=nums[0],sum=current;
        int len=nums.length;
        for(int i=1;i<len;i++){

            if(current>0){
                current+=nums[i];
            }else {
                current=nums[i];
            }

            sum=Math.max(current,sum);
        }
        return sum;

    }

    public static void main(String...args){

        int[] nums={1};

        A53最大子序和p1 a = new A53最大子序和p1();

        a.maxSubArray(nums);

    }
}
