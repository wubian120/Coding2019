package cn.bw.leetcode.sample;

public class A62不同路径s {

    public int uniquePaths(int m, int n) {
        if(m==0||n==0){
            return 0;
        }

        int[] paths= new int[n];
        paths[0]=1;

        for(int i=0;i<m;i++){
            for(int j=1;j<n;j++){
                paths[j] += paths[j-1];
            }
        }


        return paths[n-1];

    }


    public int uniquePaths1(int m, int n) {

        int[][] dp = new int[m][n];

        for(int i=0;i<m;i++){
            dp[i][0]=1;
        }

        for(int i=0;i<n;i++){
            dp[0][i]=1;
        }

        for(int r=1;r<m;r++){
            for(int c=1;c<n;c++){
                dp[r][c]= dp[r-1][c]+dp[r][c-1];
            }
        }

        return dp[m-1][n-1];
    }

}
