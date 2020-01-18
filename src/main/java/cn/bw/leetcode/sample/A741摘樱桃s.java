package cn.bw.leetcode.sample;

import java.util.Arrays;

public class A741摘樱桃s {

    int[][][] memo;
    int[][] grid;
    int N;

    public int cherryPickup(int[][] grid) {
        this.grid = grid;
        N = grid.length;
        memo = new int[N][N][N];
        for (int[][] layer : memo)
            for (int[] row : layer)
                Arrays.fill(row, Integer.MIN_VALUE);
        return Math.max(0, dp(0, 0, 0));
    }

    public int dp(int r1, int c1, int c2) {
        int r2 = r1 + c1 - c2;
        if (N == r1 || N == r2 || N == c1 || N == c2 ||
                grid[r1][c1] == -1 || grid[r2][c2] == -1) {
            return -999999;
        } else if (r1 == N - 1 && c1 == N - 1) {
            return grid[r1][c1];
        } else if (memo[r1][c1][c2] != Integer.MIN_VALUE) {
            return memo[r1][c1][c2];
        } else {
            int ans = grid[r1][c1];
            if (c1 != c2) ans += grid[r2][c2];
            ans += Math.max(Math.max(dp(r1, c1 + 1, c2 + 1), dp(r1 + 1, c1, c2 + 1)),
                    Math.max(dp(r1, c1 + 1, c2), dp(r1 + 1, c1, c2)));
            memo[r1][c1][c2] = ans;
            return ans;
        }

    }


    public int cherryPickup1(int[][] grid) {
        int n = grid.length;
        int[][][] dp = new int[n + 1][n + 1][n + 1];
        //初始化
        for (int i = 0; i <= n; i++)
            for (int j = 0; j <= n; j++)
                for (int k = 0; k <= n; k++)
                    dp[i][j][k] = -1;

        dp[1][1][1] = grid[0][0];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= Math.min(i + j, n); k++) {
                    int l = i + j - k;
                    if (l > n || l < 1) continue;
                    if (grid[i - 1][j - 1] == -1 || grid[k - 1][l - 1] == -1) continue;

                    int ans = Math.max(
                            Math.max(dp[i - 1][j][k - 1], dp[i - 1][j][k]),
                            Math.max(dp[i][j - 1][k - 1], dp[i][j - 1][k])
                    );
                    if (ans < 0) continue;
                    ans = ans + grid[i - 1][j - 1] + ((i == k && j == l) ? 0 : grid[k - 1][l - 1]);
                    dp[i][j][k] = ans;
                }
            }
        }
        return dp[n][n][n] < 0 ? 0 : dp[n][n][n];
    }

}
