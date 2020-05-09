package cn.bw.leetcode.prac.p202002;

/**
 * @ClassName : A5最长回文子串p0
 * @Description :
 * @Author : Richard.Wu
 * @Date: 2020-02-09 07:54
 */

public class A5最长回文子串p {

    public String longestPalindrome(String s) {


        if(s==null||s.length()==0)return "";

        int len=s.length();

        boolean[][] dp = new boolean[len][len];
        int maxLen=0, beginIdx=0;
        for(int r=0;r<len;r++){
            for(int l=0;l<=r;l++){
                if(s.charAt(l)==s.charAt(r)){

                    if(r-l<2||dp[l+1][r-1]){
                        dp[l][r]=true;

                        if(r-l+1>maxLen){
                            maxLen=r-l+1;
                            beginIdx=l;
                        }
                    }

                }
            }

        }

        if(beginIdx==0&&maxLen==0){
            return s.charAt(0)+"";
        }

        return s.substring(beginIdx,beginIdx+maxLen);



    }
}
