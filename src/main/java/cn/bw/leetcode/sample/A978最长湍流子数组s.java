package cn.bw.leetcode.sample;

/**
 * @ClassName : A978最长湍流子数组s
 * @Description : leetcode 978 最长湍流子数组s
 * @Author : Richard.Wu
 * @Date: 2020-01-23 18:34
 */

public class A978最长湍流子数组s {

    public int maxTurbulenceSize(int[] A) {
        int len = A.length, anchor = 0;
        int result = 1;
        for (int i = 1; i < len; i++) {
            int before = Integer.compare(A[i - 1], A[i]);

            //如果 是最后一个，或者 current 与 前后 不是 大小
            if (i == len - 1 || before * Integer.compare(A[i], A[i + 1]) != -1) {
                // current与前一个 不相等
                if (before != 0) {
                    int size = i - anchor + 1;
                    result = Math.max(result, size);
                }
                anchor = i;
            }
        }
        return result;
    }
}
