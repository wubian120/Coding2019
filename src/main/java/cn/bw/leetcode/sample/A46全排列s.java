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
 *
 * ¬
 */

public class A46全排列s {


    //   最快 解法  uncheck

    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> res = new ArrayList<List<Integer>>();

        per(nums, 0, nums.length, res);

        return res;
    }

    public void per(int[] arr,int begin,int end,List<List<Integer>> out){

        if(begin==end){

            ArrayList<Integer> temp = new ArrayList<>();

            for(int i=0;i<end;i++){
                temp.add(arr[i]);
            }

            out.add(temp);

        }else{

            for(int i=begin;i<end;i++){

                int temp = arr[i];
                arr[i] = arr[begin];
                arr[begin] = temp;

                per(arr,begin+1,end,out);

                temp = arr[i];
                arr[i] = arr[begin];
                arr[begin] = temp;

            }

        }

    }

    // 最简单解法

    // https://leetcode-cn.com/problems/permutations/solution/hui-su-suan-fa-xiang-jie-by-labuladong-2/

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
