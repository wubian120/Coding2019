package cn.bw.leetcode.prac;

public class A32r {

    public int longestValidParentheses(String s) {

        int maxLen = 0, len = s.length();

        int[] dp = new int[len];
        for(int i=1;i<len;i++){
            if(s.charAt(i)==')'){
                if(s.charAt(i-1)=='('){
                    dp[i]=(i>= 2? dp[i-2]:0)+2;
                }else if(i-dp[i-1]>0&&s.charAt(i-dp[i-1]-1)=='('){
                    dp[i]=dp[i-1]+
                            ((i-dp[i-1])>=2?dp[i-dp[i-1]-2]:0)+2;
                }
            }
            maxLen = Math.max(maxLen,dp[i]);
        }

        return maxLen;

    }
}
