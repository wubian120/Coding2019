package cn.bw.leetcode.prac;

public class A32p {

    public int longestValidParentheses(String s) {

        int max = 0;
        int len = s.length();
        int[] dp = new int[len];

        for(int i=1;i<len;i++){
            if(s.charAt(i)==')'){
                if(s.charAt(i-1)=='('){
                    dp[i]=(i>=2?dp[i-2]:0)+2;
                }else if(i-dp[i-1]>0 && (s.charAt(i-dp[i-1]-1)=='(')) {
                    dp[i]=dp[i-1]+ (i-dp[i-1]>=2 ? dp[i-dp[i-1]-2]:0)+2;
                }
                max = Math.max(dp[i],max);
            }
        }

        return max;
    }

}
