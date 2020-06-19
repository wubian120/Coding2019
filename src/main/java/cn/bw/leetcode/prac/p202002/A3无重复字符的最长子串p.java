package cn.bw.leetcode.prac.p202002;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName : A3无重复字符的最长子串p
 * @Author : Richard.Wu
 * @Date: 2020-06-13 09:49
 * @Description :
 */

public class A3无重复字符的最长子串p {

    public int lengthOfLongestSubstring(String s) {

        int len=s.length(), result=0;

        Map<Character,Integer> map = new HashMap<>();

        for(int i=0,j=0;j<len;j++){
            if(map.containsKey(s.charAt(j))){
                i = Math.max(map.get(s.charAt(j)),i);
            }
            result = Math.max(result, j-i+1);
            map.put(s.charAt(j),j+1);
        }

        return result;


    }


}
