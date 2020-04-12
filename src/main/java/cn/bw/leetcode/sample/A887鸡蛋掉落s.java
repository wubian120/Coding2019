package cn.bw.leetcode.sample;

/**
 * @ClassName : A887鸡蛋掉落s
 * @Description : leetcode 887鸡蛋掉落s
 * @Author : Richard.Wu
 * @Date: 2020-01-23 17:40
 *
 *
 *
 *
 */

public class A887鸡蛋掉落s {

    public int superEggDrop(int K, int N) {


        int[] dp =new int[K+1];
        int result = 0;

        while (dp[K]<N){
            //
            for(int i=K;i>0;i--){
                dp[i]= dp[i] + dp[i-1]+1;
            }
            result++;
        }


        return result;
    }


    public static void main(String...args){

        int k = 2, n = 6;

        A887鸡蛋掉落s a = new A887鸡蛋掉落s();

        int result = a.superEggDrop(k, n);






    }
}
