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

        if(nums==null|| nums.length==0)return 0;

        Set<Integer> set = new HashSet<>();
        for(int n : nums){
            set.add(n);
        }

        int max =0;
        for(int i:nums){
            if(set.remove(i)){
                int pre = i-1, next = i+1;

                while (set.remove(pre)){
                    pre--;
                }

                while (set.remove(next)){
                    next++;
                }
                max = Math.max(max, next-pre-1);
            }
        }
        return max;



    }
}
