package cn.bw.leetcode.prac.p202002;

/**
 * @ClassName : A10正则表达式匹配p0
 * @Author : Richard.Wu
 * @Date: 2020-02-14 10:19
 * @Description :
 * <p>
 * 2020-03-28
 */

public class A10正则表达式匹配p0 {

    public boolean isMatch(String s, String p) {

        if (p.isEmpty()) {
            return s.isEmpty();
        }

        boolean fMatch =
                (!s.isEmpty() &&
                        (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.'));

        if(p.length()>=2 && p.charAt(1)=='*'){
            return isMatch(s,p.substring(2))||
                    (fMatch&& isMatch(s.substring(1),p));
        }else {
            return fMatch && isMatch(s.substring(1),p.substring(1));
        }


    }


    //dp
    public boolean isMatch1(String s, String p) {
       return false;

    }

}
