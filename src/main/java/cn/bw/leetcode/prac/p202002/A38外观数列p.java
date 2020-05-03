package cn.bw.leetcode.prac.p202002;

/**
 * @ClassName : A38外观数列p
 * @Author : Richard.Wu
 * @Date: 2020-04-30 23:01
 * @Description :
 */

public class A38外观数列p {


    public String countAndSay(int n) {

        StringBuilder builder = new StringBuilder();
        int pre =0, cur=1;

        if(n==1){
            return "1";
        }

        String str=countAndSay(n-1);

        for(cur=1;cur<str.length();cur++){
            if(str.charAt(cur)!=str.charAt(pre)){

                int count = cur-pre;
                builder.append(count).append(str.charAt(pre));
                pre = cur;
            }
        }

        if(pre!=cur){
            int count=cur-pre;
            builder.append(count).append(str.charAt(pre));
        }

        return builder.toString();

    }

}
