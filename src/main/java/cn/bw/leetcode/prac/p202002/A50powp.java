package cn.bw.leetcode.prac.p202002;

/**
 * @ClassName : A50powp
 * @Author : Richard.Wu
 * @Date: 2020-04-06 09:36
 * @Description :
 * <p>
 * 2020-04-19
 * 2020-04-24
 */


public class A50powp {

    public double myPow(double x, int n) {

        if (n == 0) {
            return 1;
        }

        double value = divide(x, Math.abs((long) n));

        return n>0?value:1/value;

    }

    private double divide(double x, long n) {

        if(n<2){
            return x;
        }

        double sub = divide(x,n/2);

        if((n&1)==1){
            return sub*sub*x;
        }else {
            return sub*sub;
        }

    }


}
