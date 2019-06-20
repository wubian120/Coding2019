package cn.bw.leetcode;

import java.util.LinkedList;
import java.util.List;

public class A22括号生成 {

    public List<String> generateParenthesis(int n) {
        List<String> results = new LinkedList<>();
        int left = n, right = n;
        backtrack(results, "", n, n);
        return results;
    }

    private void backtrack(List<String> results, String temp, int left, int right) {

        if (left == 0 && right == 0) {
            results.add(temp);
            return;
        }
        if (left > 0) {
            backtrack(results, temp + "(", left - 1, right);
        }
        if (right > left) {
            backtrack(results, temp + ")", left, right - 1);
        }
    }
}
