package cn.bw.leetcode.prac.p202002;

import cn.bw.leetcode.sample.A51N皇后s;

import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName : A51N皇后p
 * @Author : Richard.Wu
 * @Date: 2020-04-27 10:15
 * @Description :
 */

public class A51N皇后p {

    public List<List<String>> solveNQueens(int n) {

        List<List<String>> results = new LinkedList<>();
        int[] q = new int[n];
        backtrack(q, 0, results);

        return results;

    }

    private void backtrack(int[] q, int pos, List<List<String>> results) {
        int len=q.length;
        if(pos==len){
            List<String> curList=new LinkedList<>();
            for(int i=0;i<len;i++){
                StringBuilder builder = addPoints(len);
                builder.setCharAt(q[i],'Q');
                curList.add(builder.toString());
            }
            results.add(curList);
            return;
        }

        for(int i=0;i<len;i++){
            q[pos]=i;
            if(isValid(q,pos)){
                backtrack(q,pos+1,results);
            }
        }

    }

    private boolean isValid(int[] q, int pos) {

        for (int i = 0; i < pos; i++) {
            if (q[pos] == q[i]) {
                return false;
            }

            if (Math.abs(i - pos) == Math.abs(q[i] - q[pos])) {
                return false;
            }
        }
        return true;
    }

    private StringBuilder addPoints(int n) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            builder.append('.');
        }
        return builder;
    }

    public static void main(String[] args){

        int n = 4;

        A51N皇后p a = new A51N皇后p();
        List<List<String>>results = a.solveNQueens(n);

        System.out.println("end");
    }


}
