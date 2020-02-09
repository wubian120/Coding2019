package cn.bw.leetcode.sample;

public class A72编辑距离s {
    public int minDistance(String word1, String word2) {

        //dp[i][j]  表示word1的前i个字母 和 word2的前j个字母之间的编辑距离。

        //dp[i][j] 代表最小操作数（步骤），从 word1[0..i-1]转化为 word2[0..j-1].
        int len1 = word1.length();
        int len2 = word2.length();

        int[][] dp = new int[len1 + 1][len2 + 1];

        for (int i = 0; i <= len1; i++) {
            dp[i][0]=i;
        }
        for(int i=0;i<=len2;i++){
            dp[0][i]=i;
        }

        //注意： 从1开始
        for(int i=1;i<=len1;i++){
            for(int j=1;j<=len2;j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }else {
                    
                    dp[i][j]=1+Math.min(dp[i-1][j-1],
                            Math.min(dp[i-1][j],dp[i][j-1]));
                }
            }
        }
        return dp[len1][len2];

    }
}
