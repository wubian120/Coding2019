package cn.bw.leetcode.prac.p202002;

/**
 * @ClassName : A44通配符匹配p0
 * @Description :
 * @Author : Richard.Wu
 * @Date: 2020-02-05 00:36
 * <p>
 * 1.2020-02-24 prac
 * 2.2020-02-25 test
 * 3.2020-02-26
 */

public class A44通配符匹配p {


    //题目方法：

    public boolean isMatch(String s, String p) {

        int slen=s.length();
        int plen=p.length();

        boolean[][] dp = new boolean[slen+1][plen+1];
        dp[0][0]=true;

        for(int i=1;i<=plen;i++){
            if(p.charAt(i-1)=='*'){
                dp[0][i]=dp[0][i-1];
            }
        }

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
