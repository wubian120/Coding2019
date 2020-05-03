package cn.bw.leetcode.prac.p202002;

/**
 * @ClassName : A32最长有效括号p0
 * @Description :
 * @Author : Richard.Wu
 * @Date: 2020-02-11 15:57
 */

public class A32最长有效括号p0 {

    public int longestValidParentheses(String s) {

       int result= 0;
       int len=s.length();
       int[] dp = new int[len];
       for(int i=1;i<len;i++){

           if(s.charAt(i)==')'){
               if(s.charAt(i-1)=='('){
                   dp[i]=(i-2>=0?dp[i-2]:0)+2;
               }else if((i-dp[i-1]>=1)&&s.charAt(i-dp[i-1]-1)=='('){
                   dp[i]=dp[i-1]+(i-dp[i-1]>=2?dp[i-dp[i-1]-2]:0)+2;
               }

               result = Math.max(result,dp[i]);
           }

       }
       return result;
    }

}
