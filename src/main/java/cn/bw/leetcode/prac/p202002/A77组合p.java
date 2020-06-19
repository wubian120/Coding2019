package cn.bw.leetcode.prac.p202002;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @ClassName : A77组合p
 * @Author : Richard.Wu
 * @Date: 2020-06-13 11:06
 * @Description :
 */

public class A77组合p {


    public List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> results=new LinkedList<>();
        if(n<=0||k<=0||n<k){
            return results;
        }

        backtrack(n,k,1,new Stack<>(),results);

        return results;

    }

    private void backtrack(int n, int k, int begin,
                           Stack<Integer> stack,
                           List<List<Integer>> results){

        if(stack.size()==k){
            results.add(new LinkedList<>(stack));
        }

        for(int i=begin;i<=n;i++){
            stack.add(i);
            backtrack(n,k,i+1,stack,results);
            stack.pop();
        }

    }


}
