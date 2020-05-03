package cn.bw.leetcode.prac.p202002;

import java.util.*;

/**
 * @ClassName : A46全排列p
 * @Author : Richard.Wu
 * @Date: 2020-04-18 12:28
 * @Description :
 * <p>
 * 2020-04-18
 * 2020-04-19
 */

public class A46全排列p {

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> results = new LinkedList<>();
        LinkedList<Integer> curList = new LinkedList<>();

        backtrack(curList,results,nums);

        return results;

    }

    private void backtrack(LinkedList<Integer> curList,
                           List<List<Integer>> results,
                           int[] nums) {

        if(curList.size()==nums.length){
            results.add(new LinkedList<>(curList));
        }

        for(int i=0;i<nums.length;i++){

            if(curList.contains(nums[i])){
                continue;
            }

            curList.add(nums[i]);
            backtrack(curList,results,nums);
            curList.removeLast();
        }

    }


    public static void main(String[] args) {

        int[] nums = {1, 2, 3};

        A46全排列p a = new A46全排列p();

        List<List<Integer>> results = a.permute(nums);

        System.out.println("end");
    }


}
