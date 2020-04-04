package cn.bw.leetcode.sample;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static com.sun.tools.internal.xjc.reader.Ring.add;

/**
 * @ClassName : A78子集s
 * @Author : Richard.Wu
 * @Date: 2020-04-03 15:26
 * @Description :
 */

public class A78子集s {

    //递归解法
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> output = new ArrayList();
        output.add(new ArrayList<Integer>());

        for (int num : nums) {
            List<List<Integer>> newSubsets = new ArrayList();
            for (List<Integer> curr : output) {
                newSubsets.add(new ArrayList<Integer>(curr) {
                    {
                        add(num);
                    }
                });
            }
            for (List<Integer> curr : newSubsets) {
                output.add(curr);
            }
        }
        return output;
    }


    /**
     * 回溯解法
     * @param nums
     * @return
     */
    public  List<List<Integer>> subsets1(int[] nums) {

        List<List<Integer>> results= new LinkedList<>();
        backtrack(0,nums,results,new LinkedList<>());

        return results;


    }

    private void backtrack(int idx,
                           int[] nums,
                           List<List<Integer>> results,
                           List<Integer> curList){

        results.add(new LinkedList<>(curList));
        for(int i=idx;i<nums.length;i++){

            curList.add(nums[i]);
            backtrack(i+1, nums,results, curList);
            curList.remove(curList.size()-1);

        }

    }

    public static void main(String...args){

        A78子集s a = new A78子集s();
        int[] nums= {1,2,3};

        List<List<Integer>> results = a.subsets1(nums);

        System.out.println("end");

    }

}
