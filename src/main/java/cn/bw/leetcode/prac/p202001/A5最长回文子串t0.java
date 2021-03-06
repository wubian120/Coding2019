package cn.bw.leetcode.prac.p202001;

public class A5最长回文子串t0 {

    public String longestPalindrome(String s) {
        if(s.length()<2){
            return s;
        }

        int len=s.length();
        boolean[][] dp = new boolean[len][len];
        for(int i=0;i<len;i++){
            dp[i][i]=true;
        }

        int beginIndex=0,maxLen=0;
        for(int r=0;r<len;r++){
            for (int l=0;l<r;l++){
                if(s.charAt(r)==s.charAt(l)){
                    if(l<len-1&&r>0&&(dp[l+1][r-1]||r-l==1)){
                        dp[l][r]=true;
                        if(r-l+1>maxLen){
                            maxLen =r-l+1;
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
