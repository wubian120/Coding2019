package cn.bw.leetcode.prac.p202001;

public class A115r {
    public int numDistinct(String s, String t) {
        int slen=s.length();
        int tlen = t.length();
        int[][] dp = new int[tlen+1][slen+1];

        for(int i=0;i<=slen;i++){
            dp[0][i]=1;
        }

        for(int i=1;i<=tlen;i++){
            for(int j=1;j<=slen;j++){
                if(s.charAt(j-1)==t.charAt(i-1)){
                    dp[i][j] = dp[i-1][j-1]+dp[i][j-1];
                }else {
                    dp[i][j]=dp[i][j-1];
                }
            }
        }
        return dp[tlen][slen];

    }
}
