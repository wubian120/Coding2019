package cn.bw.leetcode.prac.p202002;

/**
 * @ClassName : A125验证回文串p
 * @Author : Richard.Wu
 * @Date: 2020-06-20 14:16
 * @Description :
 */

public class A125验证回文串p {

    public boolean isPalindrome(String s) {

        StringBuffer buffer = new StringBuffer();
        int len =s.length();

        for(int i=0;i<len;i++){
            char ch = s.charAt(i);

            if(Character.isLetterOrDigit(ch)){
                buffer.append(Character.toLowerCase(ch));
            }
        }
        len=buffer.length();
        int left =0, right=len-1;

        while (left<right){
            if(buffer.charAt(left)!=buffer.charAt(right)){
                return false;
            }
            ++left;
            --right;
        }

        return true;
    }


}
