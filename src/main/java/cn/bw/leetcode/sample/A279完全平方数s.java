package cn.bw.leetcode.sample;

import java.util.Arrays;

/**
 * @ClassName : A279完全平方数s
 * @Author : Richard.Wu
 * @Date: 2020-04-25 10:17
 * @Description :
 *
 * dp[i] 的含义是 i-1 最小完全平方数 的 个数
 *
 * n = 12
 * 先把 n 减去一个平方数，然后求剩下的数分解成平方数和所需的最小个数
 *
 * 把 n 减去 1, 然后求出 11 分解成平方数和所需的最小个数,记做 n1
 * 那么当前方案总共需要 n1 + 1 个平方数
 *
 * 把 n 减去 4, 然后求出 8 分解成平方数和所需的最小个数,记做 n2
 * 那么当前方案总共需要 n2 + 1 个平方数
 *
 * 把 n 减去 9, 然后求出 3 分解成平方数和所需的最小个数,记做 n3
 * 那么当前方案总共需要 n3 + 1 个平方数
 *
 * 下一个平方数是 16, 大于 12, 不能再分了。
 *
 * 接下来我们只需要从 (n1 + 1), (n2 + 1), (n3 + 1) 三种方案中选择最小的个数,
 * 此时就是 12 分解成平方数和所需的最小个数了
 *
 *
 */

public class A279完全平方数s {

    public int numSquares(int n) {
        int dp[] = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        //依次求出 1, 2... 直到 n 的解
        for (int i = 1; i <= n; i++) {
            //依次减去一个平方数
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }


}
