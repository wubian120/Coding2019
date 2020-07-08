package cn.bw.leetcode.prac.p202002;

/**
 * @ClassName : A87p6
 * @Description :
 * @Author : Richard.Wu
 * @Date: 2020-02-09 08:59
 */

public class A87p6 {

    public boolean isScramble(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();

        if (len1 != len2) return false;
        if (s1.equals(s2)) return true;

        int[] letters = new int[26];

        for (int i = 0; i < len1; i++) {
            letters[s1.charAt(i) - 'a']++;
            letters[s2.charAt(i) - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (letters[i] != 0) {
                return false;
            }
        }

        for (int i = 1; i < len1; i++) {
            if (isScramble(s1.substring(0, i), s2.substring(0, i)) &&
                    isScramble(s1.substring(i), s2.substring(i))){
                return true;
            }

            if(isScramble(s1.substring(i),s2.substring(0,len2-i))&&
            isScramble(s1.substring(0,i),s2.substring(len2-i))){
                return true;
            }

        }

        return false;
    }

}
