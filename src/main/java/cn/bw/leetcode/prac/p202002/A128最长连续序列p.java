package cn.bw.leetcode.prac.p202002;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName : A128最长连续序列p
 * @Author : Richard.Wu
 * @Date: 2020-06-06 09:58
 * @Description :
 */

public class A128最长连续序列p {


    public int longestConsecutive(int[] nums) {


        if(nums==null||nums.length==0){
            return 0;
        }
        Set<Integer> numSet=new HashSet<>();

        for(int i:nums){
            numSet.add(i);
        }

        int maxLen=0;
        for(int i:nums){
            if(numSet.remove(i)){
                int pre=i-1, next=i+1;

                while (numSet.remove(pre)){
                    pre--;
                }
                while (numSet.remove(next)){
                    next++;
                }

                maxLen=Math.max(maxLen, next-pre-1);
            }
        }

        return maxLen;
    }
}
