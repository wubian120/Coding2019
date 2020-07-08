package cn.bw.leetcode.prac.p202002;

/**
 * @ClassName : A67二进制求和p
 * @Author : Richard.Wu
 * @Date: 2020-06-25 23:10
 * @Description :
 */

public class A67二进制求和p {

    public String addBinary(String a, String b) {

        int idxA = a.length()-1;
        int idxB = b.length()-1;
        StringBuilder builder = new StringBuilder();
        int carrier=0;
        while (idxA>=0||idxB>=0){

            int ia = idxA>=0?a.charAt(idxA--)-'0':0;
            int ib = idxB>=0?b.charAt(idxB--)-'0':0;

            int t=ia+ib+carrier;
            if(t==3){
                carrier=1;
                t=1;
            }else if(t==2){
                carrier=1;
                t=0;
            }else {
                carrier=0;
            }

            builder.insert(0,""+t);

        }
        if(carrier==1){
            builder.insert(0,"1");
        }



        return builder.toString();
    }


}
