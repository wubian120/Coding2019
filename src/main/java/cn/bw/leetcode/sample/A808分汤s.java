package cn.bw.leetcode.sample;

/**
 * @ClassName : A808
 * @Author : Richard.Wu
 * @Date: 2020-06-07 14:20
 * @Description :
 * <p>
 * dp[i,j] 表示 汤A 和 汤B 分别剩下 i， j 份时 所求概率。
 * <p>
 * 状态转移方程：
 * dp(i, j) = 1/4 * (dp(i - 4, y) + dp(i - 3, y - 1) + dp(i - 2, y - 2) + dp(i - 1, y - 3))
 * <p>
 * 边界条件：
 * dp(i, j) = 0.5   if i <= 0 and j <= 0
 * dp(i, j) = 1.0   if i <= 0 and j > 0
 * dp(i, j) = 0.0   if i > 0 and j <= 0
 */

public class A808分汤s {

    /***
     * 官方解法 ：
     * @param N
     * @return
     */

    public double soupServings(int N) {
        N = N / 25 + (N % 25 > 0 ? 1 : 0);
        if (N >= 500) return 1.0;

        double[][] memo = new double[N + 1][N + 1];
        for (int s = 0; s <= 2 * N; ++s) {
            for (int i = 0; i <= N; ++i) {
                int j = s - i;

                if (j < 0 || j > N)
                    continue;

                double ans = 0.0;

                if (i == 0) ans = 1.0;

                if (i == 0 && j == 0) ans = 0.5;

                if (i > 0 && j > 0) {
                    ans = 0.25 * (memo[M(i - 4)][j] + memo[M(i - 3)][M(j - 1)] +
                            memo[M(i - 2)][M(j - 2)] + memo[M(i - 1)][M(j - 3)]);
                }
                memo[i][j] = ans;

            }
        }
        return memo[N][N];
    }

    public int M(int x) {
        return Math.max(0, x);
    }


    /***
     *
     *
     */


    //使用数组来缓存已经 计算过的结果，进而在递归中剪枝。
    double[][] memo = new double[200][200];

    public double soupServings1(int N) {
        //>5000 trick
        //技巧，（N+24）/25 进而将25，50，75，100 缩减到 1，2，3，4. 从而减少memo 的使用。
        return N >= 5000 ? 1.0 : getProbability((N + 24) / 25, (N + 24) / 25);
    }

    //返回 A为a ml， B为bml 情况下，A先空以及AB同时为空的概率之和。
    public double getProbability(int a, int b) {
        //A 和B 同时为空的概率的 half。 这里<0 意味着不够serve。
        if (a <= 0 && b <= 0) return 0.5;
        //A 为空的概率为1
        if (a <= 0) return 1;
        //B 不可能在 A不空的情况下为空。
        if (b <= 0) return 0;
        if (memo[a][b] > 0) return memo[a][b];
        //当前阶段，分别选择 4个operation 中的某一个operation，进入下一层迭代。
        memo[a][b] = 0.25 * (getProbability(a - 4, b) + getProbability(a - 3, b - 1) + getProbability(a - 2, b - 2) + getProbability(a - 1, b - 3));
        return memo[a][b];

    }


}
