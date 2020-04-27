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

    // main,  回溯
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> reuslts=new LinkedList<>();
        LinkedList<Integer> curList=new LinkedList<>();
        dfs(0,reuslts,curList,candidates,target);

        return reuslts;

    }

    private void dfs(int idx,
                     List<List<Integer>>res,
                     LinkedList<Integer>curList, int[] nums, int target){
        if(target==0){
            res.add(new LinkedList<>(curList));
            return;
        }

        for(int i=idx;i<nums.length;i++){
            if(target<nums[i]){
                continue;
            }

            curList.add(nums[i]);
            dfs(i,res,curList,nums,target-nums[i]);
            curList.removeLast();

        }
    }


    ///

    public List<List<Integer>> combinationSum1(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(result, new ArrayList<Integer>(), candidates, target, 0);
        return result;
    }

    private void dfs(List<List<Integer>> result,
                     List<Integer> cur,
                     int[] candidates,
                     int target, int start) {

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
