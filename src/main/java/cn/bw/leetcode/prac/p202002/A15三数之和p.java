package cn.bw.leetcode.prac.p202002;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName : A15三数之和p
 * @Author : Richard.Wu
 * @Date: 2020-03-13 23:56
 * @Description :
 */

public class A15三数之和p {

    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> results = new LinkedList<>();

        Arrays.sort(nums);

        int len = nums.length;
        for (int i = 0; i < len - 2; i++) {

            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                int left=i+1, right=len-1, sum=0-nums[i];

                while (left<right){

                    if((nums[left]+nums[right])==sum){
                        results.add(Arrays.asList(nums[i],nums[left],nums[right]));

                        while (left<right&& nums[left]==nums[left+1]){
                            left++;
                        }

                        while (left<right && nums[right]==nums[right-1]){
                            right--;
                        }

                        left++;
                        right--;

                    }else if((nums[left]+nums[right])>sum){
                        right--;
                    }else {
                        left++;
                    }

                }

            }


        }


        return results;


    }

}
