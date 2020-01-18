package cn.bw.leetcode.sample;

import java.util.List;

public class A120三角形最小路径和s {
    public int minimumTotal(List<List<Integer>> triangle) {

        int rows = triangle.size();

        int[] dp = new int[rows+1];

        for(int r=rows-1;r>=0;r--){
            int cols= triangle.get(r).size();
            for(int c = 0;c<cols;c++){
                dp[c] = triangle.get(r).get(c) + Math.min(dp[c],dp[c+1]);
            }
        }

        return dp[0];
    }
}
