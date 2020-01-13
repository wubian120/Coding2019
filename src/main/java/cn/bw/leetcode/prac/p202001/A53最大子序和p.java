package cn.bw.leetcode.prac.p202001;

public class A53最大子序和p {

    public int maxSubArray(int[] nums) {

        int current = nums[0], sum=nums[0];

        for(int i=1;i<nums.length;i++){
            if(current>0){
                current += nums[i];
            }else {
                current = nums[i];
            }
            if(current>sum){
                sum = current;
            }
        }

        return sum;

    }

}
