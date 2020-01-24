package cn.bw.leetcode.prac.p2019;

public class A53r {
    public int maxSubArray(int[] nums) {

        int len = nums.length;
        int current=nums[0], sum=nums[0];

        for(int i=1;i<len;i++){
            if(current>0){
                current+=nums[i];
            }else {
                current = nums[i];
            }
            if(current>sum){
                sum=current;
            }
        }
        return sum;

    }
}
