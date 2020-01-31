package cn.bw.leetcode.prac.p202001;

/**
 * @ClassName : A10正则表达式匹配p0
 * @Description :
 * @Author : Richard.Wu
 * @Date: 2020-01-30 16:15
 */

public class A10正则表达式匹配p0 {

    public boolean isMatch(String s, String p) {

        if (p.isEmpty()) {
            return s.isEmpty();
        }

        boolean fstMatch = !s.isEmpty() &&
                (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.');

        if (p.length() >= 2 && p.charAt(1) == '*') {
            return isMatch(s, p.substring(2)) || (fstMatch && isMatch(s.substring(1), p));

        } else {
            return fstMatch && isMatch(s.substring(1), p.substring(1));
        }


    }

}
