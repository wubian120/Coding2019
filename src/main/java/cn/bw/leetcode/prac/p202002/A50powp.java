package cn.bw.leetcode.prac.p202002;

/**
 * @ClassName : A50powp
 * @Author : Richard.Wu
 * @Date: 2020-04-06 09:36
 * @Description :
 *
 * 2020-04-19
 *
 *
 */


public class A50powp {

    public double myPow(double x, int n) {

        if(n==0){
            return 1;
        }
        double result = divide(x, Math.abs((long)n));

        return n>0?result:1/result;

    }


    private double divide(double x, long n) {

        if (n < 2) {
            return x;
        }

        double sub = divide(x, n / 2);

        if (n % 2 == 0) {
            return sub * sub;
        } else {
            return sub * sub * x;
        }
    }


}
