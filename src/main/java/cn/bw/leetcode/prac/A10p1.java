package cn.bw.leetcode.prac;

public class A10p1 {

    public boolean isMatch(String s,String p){

        if(p.isEmpty()){
            return s.isEmpty();
        }
        boolean fisrtMatch =
                (s.charAt(0)==p.charAt(0)||p.charAt(0)=='.');

        if(p.length()>=2 && p.charAt(1)=='*'){
            return isMatch(s,p.substring(2))||
                    (fisrtMatch&&isMatch(s.substring(1),p));
        }else {
            return fisrtMatch && isMatch(s.substring(1),p.substring(1));
        }
    }
}
