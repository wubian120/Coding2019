package cn.bw.leetcode.sample;

import cn.bw.leetcode.prac.p202002.A174地下城游戏p;

/**
 * @ClassName : A174地下城游戏s
 * @Author : Richard.Wu
 * @Date: 2020-06-18 21:42
 * @Description :
 */

public class A174地下城游戏s {

    public int calculateMinimumHP(int[][] dungeon) {
        if (dungeon == null || dungeon.length == 0 || dungeon[0].length == 0) {
            return 0;
        }
        int rowSize = dungeon.length;
        int colSize = dungeon[0].length;
        int[][] dp = new int[rowSize][colSize];
        // 设置最后一个值。
        dp[rowSize - 1][colSize -1] = Math.max(0, -dungeon[rowSize - 1][colSize - 1]);

        // 设置最后一列的值
        for (int i = rowSize - 2; i >= 0; --i) {
            int needMin = dp[i + 1][colSize - 1] - dungeon[i][colSize - 1];
            dp[i][colSize -1] = Math.max(0, needMin);
        }

        // 设置最后一行的值
        for (int i = colSize - 2; i >= 0; --i) {
            int needMin = dp[rowSize - 1][i + 1] - dungeon[rowSize - 1][i];
            dp[rowSize - 1][i] = Math.max(0, needMin);
        }

        for (int i = rowSize - 2; i >= 0; --i) {
            for (int j = colSize - 2; j >= 0; --j) {
                // 从右边和下边选择一个最小值，然后减去当前的 dungeon 值
                int needMin = Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j];
                dp[i][j] = Math.max(0, needMin);
            }
        }
        return dp[0][0] + 1;
    }

    public static void main(String[] args){

        int[][] d = {{-2,-3,3},{-5,-10,1},{10,30,-5}};
        A174地下城游戏s a = new A174地下城游戏s();
        int re = a.calculateMinimumHP(d);

        System.out.println(re);

    }


}
