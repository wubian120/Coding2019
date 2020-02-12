package cn.bw.leetcode.sample;


/**
 * @ClassName : A32最长有效括号p0
 * @Author : Richard.Wu
 * @Date:
 * @Description :
 * leetcode 32
 *  dp[i] 表示 s的i位置的 有效括号的长度。
 *   1.遍历  从1开始
 *   2.判断i位置 是否是 ')'
 *   3.然后判断 i的前一个位置 (i-1) 和
 *   i减去前一个有效位置的长度的前一个位置 i-dp[i-1]-1
 *   是否是'('
 *   4.两种情况下 取值的问题
 *   如果 i-1 的位置是 '('  则需要判断 i-1前一个位置是否是 有效长度
 *
 *
 */
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
