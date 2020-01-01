package cn.bw.leetcode.sample;

/***
 * 1.判断 p是否为空， 返回 s是否为空
 * 2.boolean firstmatch  等于 s的第一个 等于 p的 第一个或 p的第一个是 .
 * 3.如果p长度大于二， 且 p的第二个元素是 *
 * 4. 则 递归调用 isMatch(s, 和 p地第三个元素 或 )
 * 5.否则 firstmatch 并 递归isMatch 元素是 s.subString, p.subString
 */
public class A10正则表达式匹配 {

    public boolean isMatch(String s, String p){
        if(p.isEmpty()){
            return s.isEmpty();
        }
        boolean firstMatch
                = (!s.isEmpty()) &&
                (p.charAt(0)==s.charAt(0) || (p.charAt(0)=='.'));

        if(p.length()>=2 && p.charAt(1)=='*'){

            return isMatch(s,p.substring(2)) || (firstMatch && isMatch(s.substring(1),p));

        }else {
            return firstMatch && isMatch(s.substring(1),p.substring(1));
        }
    }

}
