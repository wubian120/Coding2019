package cn.bw.leetcode.sample;

/**
 * @ClassName : A50Pows
 * @Author : Richard.Wu
 * @Date: 2020-04-04 23:59
 * @Description :
 */

public class A50Pows {
    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        double v = divideGenerate(x, Math.abs((long) n));
        return n >= 0 ? v : 1 / v;
    }

    private double divideGenerate(double x, long n) {
        // 1 终止条件
        if (n < 2) {
            return x;
        }

        // 3 子问题
        double sub = divideGenerate(x, n / 2);

        // 4 合并

        if (n % 2 == 0) {
            return sub * sub;
        } else {
            return sub * sub * x;
        }
    }

    public static void main(String[] args){

        int n =10;
        double x = 2.1;

        A50Pows a = new A50Pows();
        double result = a.myPow(x, n);



    }

}
