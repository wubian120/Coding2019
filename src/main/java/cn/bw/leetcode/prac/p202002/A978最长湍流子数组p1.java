package cn.bw.leetcode.prac.p202002;

/**
 * @ClassName : A978最长湍流子数组p1
 * @Author : Richard.Wu
 * @Date: 2020-02-12 12:03
 * @Description :
 */

public class A978最长湍流子数组p1 {


    public int maxTurbulenceSize(int[] A) {
        int len=A.length;
        int begin=0, result=1;

        for(int i=1;i<len;i++){
            int before=Integer.compare(A[i-1],A[i]);

            if(i==len-1 || before*Integer.compare(A[i],A[i+1])!=-1){

                if(before!=0){
                    result=Math.max(result,i-begin+1);
                }

                begin=i;
            }

        }
        return result;

    }



}
