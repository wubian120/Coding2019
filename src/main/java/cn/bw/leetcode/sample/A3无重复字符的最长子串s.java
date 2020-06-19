package cn.bw.leetcode.sample;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName : A3无重复字符的最长子串s
 * @Author : Richard.Wu
 * @Date: 2020-06-13 09:48
 * @Description :
 */

public class A3无重复字符的最长子串s {

    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j+1 );
        }
        return ans;
    }

}
