package cn.bw.leetcode.prac.p202002;

/**
 * @ClassName : A0106字符串压缩p
 * @Author : Richard.Wu
 * @Date: 2020-03-16 09:40
 * @Description :
 */

public class B0106字符串压缩p {

    public String compressString(String S) {

        int len=S.length();
        if(S==null||len<=1)return S;

        StringBuilder builder = new StringBuilder();
        int l=0,r=1;
        while (r<len){
            if(S.charAt(r)!=S.charAt(l)){

                builder.append(S.charAt(l));
                builder.append((r-l)+"");
                l=r;
            }
            r++;
        }

        builder.append(S.charAt(l));
        builder.append((r-l)+"");

        return builder.length()>=len?S:builder.toString();

    }


}
