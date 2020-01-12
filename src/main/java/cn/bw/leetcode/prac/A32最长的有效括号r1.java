package cn.bw.leetcode.prac;

/***
 * 思路
 * dp[i] 表示 前i个字符，最长有效括号长度
 * 只有 i位置的字符 == ）时 才可能是有效的。从 判断i位置字符开始 往回走
 * 1.判断i位置 是否为)
 * 2.如果是 两种情况， 第一种，i的前一个位置i-1 是（
 * 2.1 如果是 则需要 判断i是否 >=2, 才能判断前面是否有更多有效括号。
 * 2.2 dp[i]=dp[i-2]+2    dp[i-2] 是 前一个位置 (之前的有效长度
 *
 * 3.另一种情况是 i的前一个位置 不是(, 是） 隔着好几个） 才形成有效括号。
 * 这个时候需要 判断 i-dp[i-1] 是否>0 && i-dp[i-1]-1 位置是否是（ ；
 * i - 前一个位置（i-1）的有效长度的前一个位置 .
 * 如果是：
 *
 * 4.边界 从1开始循环 到 len;
 */

public class A32最长的有效括号r1 {

    public int longestValidParentheses(String s) {

        int max = 0;
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0
                        && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1]
                            + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0)
                            + 2;
                }
                max = Math.max(max,dp[i]);
            }
        }

        return max;
    }


}
