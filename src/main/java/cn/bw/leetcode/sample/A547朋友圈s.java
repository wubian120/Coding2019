package cn.bw.leetcode.sample;

import java.util.Arrays;

/**
 * @ClassName : A547朋友圈s
 * @Author : Richard.Wu
 * @Date: 2020-05-10 08:03
 * @难度: 中等
 * @Description :
 *
 * https://leetcode-cn.com/problems/friend-circles/
 *
 * 解法：
 * 1.深度优先遍历
 * 2.广度优先遍历
 * 3.并查集
 *
 *
 */

public class A547朋友圈s {



    //解法 1， 深度优先遍历
    public int findCircleNum(int[][] M) {
        int[] visited = new int[M.length];
        int count = 0;
        for (int i = 0; i < M.length; i++) {
            if (visited[i] == 0) {
                dfs(M, visited, i);
                count++;
            }
        }
        return count;
    }

    public void dfs(int[][] M, int[] visited, int i) {
        for (int j = 0; j < M.length; j++) {
            if (M[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                dfs(M, visited, j);
            }
        }
    }



    //解法2： 并查集
    int find(int parent[], int i) {
        if (parent[i] == -1)
            return i;
        return find(parent, parent[i]);
    }

    void union(int parent[], int x, int y) {
        int xset = find(parent, x);
        int yset = find(parent, y);

        // 合并 两个 x, y 父
        if (xset != yset)
            parent[xset] = yset;
    }
    //parent[i] 表示 i的父亲
    public int findCircleNum2(int[][] M) {
        int[] parent = new int[M.length];
        Arrays.fill(parent, -1);
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M.length; j++) {
                if (M[i][j] == 1 && i != j) {
                    union(parent, i, j);
                }
            }
        }
        int count = 0;
        for (int i = 0; i < parent.length; i++) {
            if (parent[i] == -1)
                count++;
        }
        return count;
    }


}
