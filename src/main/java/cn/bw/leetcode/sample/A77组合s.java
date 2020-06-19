package cn.bw.leetcode.sample;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName : A77组合s
 * @Author : Richard.Wu
 * @Date: 2020-06-13 11:04
 * @Description :
 */

public class A77组合s {




    //回溯解法
    public List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> res= new LinkedList<>();
        if(n<=0||k<=0||n<k){
            return res;
        }
        findCombinations(n,k,1,new Stack<>(),res);

        return res;
    }

    private void findCombinations(int n, int k, int begin,
                                  Stack<Integer> pre,
                                  List<List<Integer>> res) {
        if(pre.size()==k){
            res.add(new ArrayList<>(pre));
            return;
        }

        for(int i=begin;i<=n;i++){
            pre.add(i);
            findCombinations(n,k,i+1,pre,res);
            pre.pop();
        }

    }
}
