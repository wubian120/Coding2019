package cn.bw.leetcode.sample.offer;

/**
 * @ClassName : O15二进制中1的个数s
 * @Author : Richard.Wu
 * @Date: 2020-07-02 22:11
 * @Description :
 */

public class O15二进制中1的个数s {

    public int hammingWeight(int n) {

        int count = 0;

        while (n != 0) {
            count += n & 1;
            n >>>= 1;
        }

        return count;
    }


}
