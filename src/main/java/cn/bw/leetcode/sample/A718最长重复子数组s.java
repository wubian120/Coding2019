package cn.bw.leetcode.sample;

/**
 * @ClassName : A718最长重复子数组s
 * @Author : Richard.Wu
 * @Date: 2020-07-04 07:03
 * @Description :
 *
 * dp 问题
 *
 * dp[i][j] A，B 数组在 i,j 位置的 公共子数组的长度。
 *
 */

public class A718最长重复子数组s {

    public int findLength(int[] A, int[] B) {
        int lenA = A.length;
        int lenB = B.length;
        int[][] dp = new int[lenA + 1][lenB + 1];
        int result = 0;
        for (int ia = 1; ia <= lenA; ia++) {
            for (int ib = 1; ib <= lenB; ib++) {
                if (A[ia - 1] == B[ib - 1]) {
                    dp[ia][ib] = dp[ia - 1][ib - 1] + 1;
                } else {
                    dp[ia][ib] = 0;
                }

                result = Math.max(result, dp[ia][ib]);
            }
        }

        return result;
    }


}
