package cn.bw.leetcode.prac.p202002;

/**
 * @ClassName : A174地下城游戏p
 * @Author : Richard.Wu
 * @Date: 2020-06-18 21:48
 * @Description :
 */

public class A174地下城游戏p {

    public int calculateMinimumHP(int[][] dungeon) {
        if(dungeon==null||dungeon.length==0||dungeon[0].length==0) return 0;

        int rows=dungeon.length;
        int cols = dungeon[0].length;

        int[][] dp = new int[rows][cols];

        dp[rows-1][cols-1] = Math.max(0,-dungeon[rows-1][cols-1]);

        for(int i=rows-2;i>=0;i--){
            int need = dp[i+1][cols-1]-dungeon[i][cols-1];
            dp[i][cols-1] = Math.max(0,need);
        }

        for(int j=cols-2;j>=0;j--){
            int need = dp[rows-1][j+1] - dungeon[rows-1][j];
            dp[rows-1][j]=Math.max(0,need);
        }

        for(int r=rows-2;r>=0;r--){
            for(int c=cols-2;c>=0;c--){
                int need = Math.min(dp[r+1][c],dp[r][c+1]) - dungeon[r][c];
                dp[r][c]=Math.max(0,need);
            }
        }

        return dp[0][0]+1;

    }

    public static void main(String[] args) {

        int[][] d = {{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}};
        A174地下城游戏p a = new A174地下城游戏p();
        int re = a.calculateMinimumHP(d);

        System.out.println(re);

    }


}
