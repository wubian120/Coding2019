package cn.bw.leetcode.sample;

/**
 * @ClassName : A125验证回文串s
 * @Author : Richard.Wu
 * @Date: 2020-06-20 12:00
 * @Description :
 */

public class A125验证回文串s {

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
