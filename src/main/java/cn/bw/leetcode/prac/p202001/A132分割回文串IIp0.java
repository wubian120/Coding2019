package cn.bw.leetcode.prac.p202001;

/**
 * @ClassName : A132分割回文串IIp0
 * @Description :
 * @Author : Richard.Wu
 * @Date: 2020-02-01 20:25
 */

public class A132分割回文串IIp0 {

    public int minCut(String s) {
        int len=s.length();
        int[] results=new int[len];
        boolean[][] dp=new boolean[len][len];

        for(int r=0;r<len;r++){
            results[r]=r;
            for(int l=0;l<=r;l++){
                if(s.charAt(l)==s.charAt(r)){
                    if(r-l<2||dp[l+1][r-1]){
                        dp[l][r]=true;
                        results[r]=l==0?0:Math.min(results[r],results[l-1]+1);
                    }
                }

            }
        }
        return results[len-1];



    }
}
