package cn.bw.leetcode.prac.p202002;

/**
 * @ClassName : A132分割回文串IIp1
 * @Description :
 * @Author : Richard.Wu
 * @Date: 2020-02-04 13:10
 */

public class A132分割回文串IIp1 {

    public int minCut(String s) {

        int len=s.length();
        int[] steps=new int[len];
        boolean[][] dp=new boolean[len][len];

        for(int r=0;r<len;r++){
            steps[r]=r;
            for(int l=0;l<=r;l++){
                if(s.charAt(r)==s.charAt(l)){
                    if(r-l<2||dp[l+1][r-1]){
                        dp[l][r]=true;
                        steps[r]=l==0?0:
                                Math.min(steps[r],steps[l-1]+1);
                    }
                }
            }
        }

        return steps[len-1];
    }
}
