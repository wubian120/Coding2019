package cn.bw.leetcode.prac.p202001;

/**
 * @ClassName : A10正则表达式匹配p1
 * @Description :
 * @Author : Richard.Wu
 * @Date: 2020-01-31 17:57
 */

public class A10正则表达式匹配p1 {

    public boolean isMatch(String s, String p) {

        if(p.isEmpty()){
            return s.isEmpty();
        }

        boolean fst = (!s.isEmpty() && (s.charAt(0)==p.charAt(0)||p.charAt(0)=='.'));

        if(p.length()>=2 && p.charAt(1)=='*'){

            return (fst && isMatch(s.substring(1),p)) || (isMatch(s,p.substring(2)));
        }else {
            return fst && isMatch(s.substring(1),p.substring(1));
        }

    }


}
