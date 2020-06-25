package cn.bw.leetcode.prac.p202002;

import java.util.List;

/**
 * @ClassName : A120三角形最小路径和p0
 * @Description :
 * @Author : Richard.Wu
 * @Date: 2020-02-09 11:21
 * <p>
 * 2020-04-27
 */

public class A120三角形最小路径和p0 {

    public int minimumTotal(List<List<Integer>> triangle) {

        if (triangle == null || triangle.size() == 0) return 0;

        int rows = triangle.size();

        int[] dp = new int[rows+1];

        for(int i=rows-1;i>=0;i--){
            int cols = triangle.get(i).size();

            for(int j=0;j<cols;j++){
                dp[j] =triangle.get(i).get(j)+Math.min(dp[j],dp[j+1]);
            }
        }

        return dp[0];

    }
}
