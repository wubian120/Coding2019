package cn.bw.leetcode.sample;

public class A32最长有效括号s {

    public int longestValidParentheses(String s) {
        int maxans = 0;
        int dp[] = new int[s.length()];

        //从1 开始遍历，
        for (int i = 1; i < s.length(); i++) {
            //如果是有效的括号， 最左必然是 (
            if (s.charAt(i) == ')') {

                if (s.charAt(i - 1) == '(') {

                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;

                } else if (i - dp[i - 1] > 0
                        && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1]
                            + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0)
                            + 2;
                }
                maxans = Math.max(maxans, dp[i]);
            }
        }
        return maxans;
    }



    public static void main(String[] args){

        String s = "())((())";
        String s1 = "()()(())";

        A32最长有效括号s a = new A32最长有效括号s();
        int result = a.longestValidParentheses(s);

        System.out.println(result);

    }



}
