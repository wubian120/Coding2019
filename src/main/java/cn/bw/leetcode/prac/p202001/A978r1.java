package cn.bw.leetcode.prac.p202001;

/**
 * @ClassName : A978r1
 * @Description :
 * @Author : Richard.Wu
 * @Date: 2020-01-30 12:38
 */

public class A978r1 {

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
