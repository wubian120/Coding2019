package cn.bw.leetcode.sample;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class A120三角形最小路径和s {
    public int minimumTotal(List<List<Integer>> triangle) {

        int rows = triangle.size();

        //注意：  rows+1;
        //因为根据 三角形， 所以 每一列 应该 是 行数索引+1
        int[] dp = new int[rows+1];

        for (int r = rows - 1; r >= 0; r--) {
            int cols = triangle.get(r).size();
            for (int c = 0; c < cols; c++) {
                //注意 dp[c+1], 如果 dp初始化 不是row+1，此处会越界
                dp[c] = triangle.get(r).get(c) + Math.min(dp[c], dp[c + 1]);
            }
        }

        return dp[0];
    }

    public static void main(String... args) {

        Integer[][] nums = {
                {2},
                {3, 4},
                {6, 5, 7},
                {4, 1, 8, 3}
        };
        List<Integer> t3 = Arrays.asList(nums[3]);
        List<Integer> t2 = Arrays.asList(nums[2]);
        List<Integer> t1 = Arrays.asList(nums[1]);
        List<Integer> t0 = Arrays.asList(nums[0]);

        List<List<Integer>> tri = new LinkedList<>();

        tri.add(t0);
        tri.add(t1);
        tri.add(t2);
        tri.add(t3);

        A120三角形最小路径和s a = new A120三角形最小路径和s();

        int result = a.minimumTotal(tri);

        System.out.println(result);


    }
}
