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

        LinkedList<Integer> curList=new LinkedList<>();
        List<List<Integer>> results=new LinkedList<>();
        backtrack(0,candidates,curList,results,target);

        return results;



    }

    private void backtrack(int idx,int[] nums, LinkedList<Integer> curList,
                           List<List<Integer>> results, int target){


        if(target==0){
            results.add(new LinkedList<>(curList));
            return;
        }

        for(int i=idx;i<nums.length;i++){
            if(nums[i]>target){
                continue;
            }

            curList.add(nums[i]);
            backtrack(i,nums,curList,results,target-nums[i]);
            curList.removeLast();
        }


    }










}
