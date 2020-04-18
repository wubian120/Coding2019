package cn.bw.leetcode.prac.p202002;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName : A39
 * @Author : Richard.Wu
 * @Date: 2020-04-17 21:33
 * @Description :
 */

public class A39组合总和p {


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates==null||candidates.length==0){
            return null;
        }

        List<List<Integer>> results=new LinkedList<>();
        Arrays.sort(candidates);

        List<Integer> curList=new LinkedList<>();
        backtrack(curList,0,target,candidates,results);

        return results;


    }


    private void backtrack(List<Integer> curList,
                           int idx, int target, int[] nums,
                           List<List<Integer>> results){
        if(target<0) return;

        if(target==0){
            results.add(new LinkedList<>(curList));
            return;
        }

        for(int i=idx;i<nums.length;i++){
            if(nums[i]>target)break;

            curList.add(nums[i]);
            backtrack(curList,i,target-nums[i],nums,results);
            curList.remove(curList.size()-1);
        }




    }






}
