package cn.bw.leetcode.prac.p202002;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName : A78子集p
 * @Author : Richard.Wu
 * @Date: 2020-04-03 15:40
 * @Description :
 */

public class A78子集p {

    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> results = new LinkedList<>();
        backtrack(0, nums, results, new LinkedList<>());

        return results;
    }

    private void backtrack(int idx,
                           int[] nums,
                           List<List<Integer>> results,
                           List<Integer> curList) {

        results.add(new LinkedList<>(curList));
        for (int i = idx; i < nums.length; i++) {

            curList.add(nums[i]);
            backtrack(i + 1, nums, results, curList);

            curList.remove(curList.size() - 1);
        }
    }


}
