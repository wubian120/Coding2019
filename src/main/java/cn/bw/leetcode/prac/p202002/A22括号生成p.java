package cn.bw.leetcode.prac.p202002;

import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName : A22括号生成p
 * @Author : Richard.Wu
 * @Date: 2020-03-10 11:24
 * @Description :
 */

public class A22括号生成p {

    public List<String> generateParenthesis(int n) {

        List<String> results=new LinkedList<>();

        int left=n,right=n;
        backTrack(results,"",left,right);

        return results;

    }


    private void backTrack(List<String> results, String temp, int left, int right) {

        if (left == 0 && right == 0) {
            results.add(temp);
            return;
        }

        if (left > 0) {
            backTrack(results, temp + "(", left - 1, right);
        }

        if (right > left) {
            backTrack(results, temp + ")", left, right - 1);
        }
    }

}
