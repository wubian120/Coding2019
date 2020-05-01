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

        int pOne=0;
        int cur = 1;
        if(n==1){
            return "1";
        }

        String str=countAndSay(n-1);

        for(cur=1;cur<str.length();cur++){
            //如果当前字符与前一个字符不等，则更新
            if(str.charAt(pOne)!=str.charAt(cur)){
                int count=cur-pOne;
                builder.append(count).append(str.charAt(pOne));
                pOne = cur;
            }

        }

        if(pOne!=cur){
            int count=cur-pOne;
            builder.append(count).append(str.charAt(pOne));
        }
        return builder.toString();


    }

}
