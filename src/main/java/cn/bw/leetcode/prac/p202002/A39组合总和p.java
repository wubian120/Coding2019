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
 *
 */

public class A39组合总和p {


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









}
