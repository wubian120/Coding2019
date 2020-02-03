package cn.bw.leetcode.prac.p202001;

/**
 * @ClassName : A978p0
 * @Description :
 * @Author : Richard.Wu
 * @Date: 2020-02-01 20:46
 */

public class A978p0 {

    public int maxTurbulenceSize(int[] A) {

        int len=A.length, begin=0;
        int result = 1;
        for(int i=1;i<len;i++){
            int before=Integer.compare(A[i-1],A[i]);

            if(i==len-1||(before*Integer.compare(A[i],A[i+1])!=-1)){
                if(before!=0){
                    int size=i-begin+1;
                    result=Math.max(result,size);
                }
                begin=i;
            }

        }
        return result;



    }


}
