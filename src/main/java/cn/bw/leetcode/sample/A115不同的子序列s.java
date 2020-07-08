package cn.bw.leetcode.sample;


/***
 *
 * leetcode.115 不同的子序列
 *
 * 字符串 S, T。    计算 S的子序列中 T出现的次数。
 * S="babgbag"  T="bag"   输出 5
 *
 *  dp[i][j] 表示： T的 前i 字符 可以有 S j字符串 组成最多个数。
 */
public class A115不同的子序列s {
    public int numDistinct(String s, String t) {
        int slen=s.length(), tlen=t.length();
        int[][] dp = new int[tlen+1][slen+1];

        for(int j=0;j<=slen;j++){
            dp[0][j]=1;
        }

        for(int i=1;i<=tlen;i++){
            for(int j=1;j<=slen;j++){
                if(s.charAt(j-1)==t.charAt(i-1)){
                    dp[i][j] = dp[i-1][j-1]+dp[i][j-1];
                }else {
                    dp[i][j] = dp[i][j-1];
                }
            }
        }

        return dp[tlen][slen];
    }
}
