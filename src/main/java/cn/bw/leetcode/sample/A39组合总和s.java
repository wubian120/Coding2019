package cn.bw.leetcode.sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName : A39组合总和s
 * @Author : Richard.Wu
 * @Date: 2020-04-17 21:10
 * @Description :
 */

public class A39组合总和s {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        if(candidates==null||candidates.length==0||target==0){
            return null;
        }
        List<List<Integer>> results=new LinkedList<>();

        Arrays.sort(candidates);

        List<Integer> curList=new LinkedList<>();
        backtrack(curList,target,0,candidates,results);

        return results;


    }


    private void backtrack(List<Integer> curList,
                           int target,
                           int idx, int[] nums, List<List<Integer>> results){
        if(target<0){
            return;
        }
        if(target==0){
            results.add(new LinkedList<>(curList));
            return;
        }
        for(int i=idx;i<nums.length;i++){
            if(nums[i]>target){
                break;
            }
            curList.add(nums[i]);
            backtrack(curList,target-nums[i],i,nums,results);
            curList.remove(curList.size()-1);
        }

    }



    ///

    public List<List<Integer>> combinationSum1(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(result, new ArrayList<Integer>(), candidates, target, 0);
        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> cur, int[] candidates, int target, int start) {
        if (target == 0) {
            result.add(new ArrayList<>(cur));
        }
        for (int i = start; i < candidates.length; i++) {
            if (target < candidates[i]) continue;//如果target<当前数，则跳过
            cur.add(candidates[i]);
            dfs(result, cur, candidates, target - candidates[i], i);
            cur.remove(cur.size() - 1);
        }
    }




}
