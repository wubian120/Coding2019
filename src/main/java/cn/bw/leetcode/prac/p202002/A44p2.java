package cn.bw.leetcode.prac.p202002;

/**
 * @ClassName : A44p2
 * @Author : Richard.Wu
 * @Date: 2020-02-15 13:08
 * @Description :
 */

public class A44p2 {
    public boolean isMatch(String s, String p) {

        boolean[][] dp=new boolean[s.length()+1][p.length()+1];
        dp[0][0]=true;

        for(int i=1;i<=p.length();i++){
            if(p.charAt(i-1)=='*'){
                dp[0][i]=dp[0][i-1];
            }
        }
        int slen=s.length(), plen=p.length();
        for(int i=1;i<=slen;i++){
            for(int j=1;j<=plen;j++){
                if(s.charAt(i-1)==p.charAt(j-1)||p.charAt(j-1)=='?'){
                    dp[i][j]=dp[i-1][j-1];

                }else if(p.charAt(j-1)=='*'){
                    dp[i][j]=dp[i][j-1]||dp[i-1][j];
                }
            }
        }

        return dp[slen][plen];
    }
}
