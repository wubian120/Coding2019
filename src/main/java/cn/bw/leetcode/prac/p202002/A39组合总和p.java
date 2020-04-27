package cn.bw.leetcode.prac.p202002;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName : A39
 * @Author : Richard.Wu
 * @Date: 2020-04-17 21:33
 * @Description :
 *
 * 2020-04-18
 * 2020-04-19
 * 2020-04-25
 *
 */

public class A39组合总和p {


    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> results=new LinkedList<>();
        LinkedList<Integer> curList= new LinkedList<>();
        backtrack(0,curList,results,target,candidates);

        return results;


    }

    private void backtrack(int idx, LinkedList<Integer> curList,
                           List<List<Integer>> results,
                           int target, int[] nums){


        if(target<0)return;
        if(target==0){
            results.add(new LinkedList<>(curList));
            return;
        }

        for(int i=idx;i<nums.length;i++){
            if(target<nums[i]){
                continue;
            }
            curList.add(nums[i]);
            backtrack(i,curList,results,target-nums[i],nums);
            curList.removeLast();
        }
    }











}
