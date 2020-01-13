package cn.bw.leetcode.prac.p202001;

public class A32最长的有效括号p {

    public int longestValidParentheses(String s) {
        int maxLen=0, len=s.length();
        int[] dp =new int[len];

        for(int i=1;i<len;i++){
            if(s.charAt(i)==')'){
                if(s.charAt(i-1)=='('){
                    dp[i]=(i-2>=0?dp[i-2]:0)+2;
                }else if(i-dp[i-1]>0&&s.charAt(i-dp[i-1]-1)=='('){
                    dp[i]=dp[i-1]+(i-dp[i-1]-2>=0?dp[i-dp[i-1]-2]:0)+2;
                }
            }
            maxLen = Math.max(dp[i],maxLen);
        }

        return maxLen;
    }

}
