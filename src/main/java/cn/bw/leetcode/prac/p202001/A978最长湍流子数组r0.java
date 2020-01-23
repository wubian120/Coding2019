package cn.bw.leetcode.prac.p202001;

/**
 * @ClassName : A978最长湍流子数组r0
 * @Description : leetcode 978 r0
 * @Author : Richard.Wu
 * @Date: 2020-01-23 18:58
 */

public class A978最长湍流子数组r0 {

    public int maxTurbulenceSize(int[] A) {
        int len=A.length, begin=0;
        int result =1;
        for(int i=1;i<len;i++){
            int compareBefore=Integer.compare(A[i-1],A[i]);

            if(i==len-1|| (compareBefore * Integer.compare(A[i],A[i+1]))!=-1){
                if(compareBefore!=0){
                    int size=i-begin+1;
                    result=Math.max(result,size);
                }
                begin=i;
            }

        }
        return result;

    }


}
