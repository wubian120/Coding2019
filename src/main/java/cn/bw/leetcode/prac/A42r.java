package cn.bw.leetcode.prac;

public class A42r {


    public int trap(int[] A){
        int start=0,end=A.length-1;
        int result=0,left=0,right=0;
        while (start<end){
            left = Math.max(A[start],left);
            right = Math.max(A[end],right);

            if(left<right){
                result += (left-A[start]);
                start++;
            }else {
                result+= (right-A[end]);
                end--;
            }
        }
        return result;
    }
}
