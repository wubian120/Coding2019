package cn.bw.leetcode.sample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName : A46全排列s
 * @Author : Richard.Wu
 * @Date: 2020-04-18 10:39
 * @Description :
 */

public class A46全排列s {


    // 回溯解法  官方

    public List<List<Integer>> permute(int[] nums) {

        int len = nums.length;
        List<List<Integer>> results = new LinkedList<>();
        List<Integer> numList = new LinkedList<>();


        for (int n : nums) {
            numList.add(n);
        }

        backtrack(0, len, numList, results);


        return results;
    }

    private void backtrack(int idx, int len, List<Integer> numList,
                           List<List<Integer>> results) {
        if (idx == len) {
            results.add(new LinkedList<>(numList));
        }

        for (int i = idx; i < len; i++) {

            Collections.swap(numList, idx, i);
            backtrack(idx + 1, len, numList, results);
            Collections.swap(numList, idx, i);
        }
    }


    ///https://leetcode-cn.com/problems/permutations/solution/hui-su-suan-fa-xiang-jie-by-labuladong-2/

    List<List<Integer>> permute2(int[] nums) {
        List<List<Integer>> res = new LinkedList();
        // 记录「路径」
        LinkedList<Integer> track = new LinkedList<>();
        backtrack(nums, track, res);
        return res;
    }

    // 路径：记录在 track 中
// 选择列表：nums 中不存在于 track 的那些元素
// 结束条件：nums 中的元素全都在 track 中出现
    void backtrack(int[] nums, LinkedList<Integer> track, List<List<Integer>> res) {
        // 触发结束条件
        if (track.size() == nums.length) {
            res.add(new LinkedList(track));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // 排除不合法的选择
            if (track.contains(nums[i]))
                continue;
            // 做选择
            track.add(nums[i]);
            // 进入下一层决策树
            backtrack(nums, track,res);
            // 取消选择
            track.removeLast();
        }
    }


}
