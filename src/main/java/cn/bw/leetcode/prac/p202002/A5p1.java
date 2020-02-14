package cn.bw.leetcode.prac.p202002;

/**
 * @ClassName : A5p1
 * @Author : Richard.Wu
 * @Date: 2020-02-14 10:11
 * @Description :
 */

public class A5p1 {

    public String longestPalindrome(String s) {
        int len=s.length();
        if(len<2){
            return s;
        }

        boolean[][] dp=new boolean[len][len];
        int maxLen=0, beginIndex=0;

        for(int i=0;i<len;i++){
            dp[i][i]=true;
        }

        for(int r=0;r<len;r++){
            for(int l=0;l<r;l++){
                if(s.charAt(r)==s.charAt(l)){
                    if(l<len-1&&r>0 &&(dp[l+1][r-1]||r-l==1)){
                        dp[l][r]=true;

                        if(r-l+1>maxLen){
                            maxLen=r-l+1;
                            beginIndex=l;
                        }
                    }
                }
            }
        }

        if(maxLen==0&&beginIndex==0){
            return s.charAt(0)+"";
        }

        return s.substring(beginIndex,beginIndex+maxLen);

    }

}
